package com.devmind.ShoeDog.Services;
import com.devmind.ShoeDog.dtos.*;
import com.devmind.ShoeDog.repos.ReviewRepository;
import com.devmind.ShoeDog.security.Role;
import com.devmind.ShoeDog.models.User;
import com.devmind.ShoeDog.repos.UserRepository;
import com.devmind.ShoeDog.security.JWTService;
import com.devmind.ShoeDog.security.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.GrantedAuthority;


import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTService jwtHelper;

    @Autowired
    ReviewRepository reviewRepository;

    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtHelper.generateJwtCookie(userDetails);

        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).get(0);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new LoginResponseDTO(userDetails.getEmail(), jwtCookie.getValue(), role));
    }

    @Transactional
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email used");
        }

        String role = registerRequestDTO.getRole();

        if (role == null || !(role.toUpperCase().equals("USER") || role.toUpperCase().equals("ADMIN"))) {
            throw new RuntimeException("Invalid role");
        }


        User user = new User(registerRequestDTO.getEmail(), registerRequestDTO.getFirstName(), registerRequestDTO.getLastName(), encoder.encode(registerRequestDTO.getPassword()), Role.valueOf(role), new Date());

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    public UserDetailsResponseDTO getUserDetails(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow();
        Integer no_reviews = reviewRepository.countByUserEmail(email);
        UserDetailsResponseDTO dto = new UserDetailsResponseDTO(user.getEmail(), user.getFirstName(), user.getLastName(), no_reviews, user.getAbout(), user.getProfile_url());
        return dto;
    }

    @Modifying
    public UserDetailsResponseDTO updateUserDetails(UserDetailsRequestDTO userDetailsRequestDTO) {
        User user = userRepository.findUserByEmail(userDetailsRequestDTO.getEmail()).orElseThrow();
        Integer no_reviews = reviewRepository.countByUserEmail(userDetailsRequestDTO.getEmail());
        user.setFirstName(userDetailsRequestDTO.getFirstName());
        user.setLastName(userDetailsRequestDTO.getLastName());
        user.setAbout(userDetailsRequestDTO.getAbout());
        user.setProfile_url(userDetailsRequestDTO.getProfile_url());
        userRepository.save(user);
        UserDetailsResponseDTO dto = new UserDetailsResponseDTO(user.getEmail(), user.getFirstName(), user.getLastName(), no_reviews, user.getAbout(), user.getProfile_url());
        return dto;
    }
}
