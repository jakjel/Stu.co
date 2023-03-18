package org.s3.individualassignment.backend.business.impl;

import lombok.RequiredArgsConstructor;
import org.s3.individualassignment.backend.business.impl.exceptions.InvalidCredentialsException;
import org.s3.individualassignment.backend.domain.AccessToken;
import org.s3.individualassignment.backend.domain.LoginRequest;
import org.s3.individualassignment.backend.domain.LoginResponse;
import org.s3.individualassignment.backend.interfaces.SignManager;
import org.s3.individualassignment.backend.interfaces.UserRepository;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SignManagerImpl implements SignManager {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findBuUsername(loginRequest.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserEntity user) {
        Long userId = user != null ? user.getUser_id() : null; //changed
        String role = user.getRole().toString();
        List<String> roles = new ArrayList<>(); //mozna dostanu problem TADY!!! predtim to bylo jinak, delali stream z roles co dostali, ja vytvarim ArrayList
        roles.add(role);

        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(user.getUsername())
                        .roles(roles)
                        .userId(userId)
                        .build());
    }
}
