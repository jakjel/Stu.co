package org.s3.individualassignment.backend.controller;


import lombok.RequiredArgsConstructor;
import org.s3.individualassignment.backend.domain.LoginRequest;
import org.s3.individualassignment.backend.domain.LoginResponse;
import org.s3.individualassignment.backend.interfaces.SignManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/login")
@RequiredArgsConstructor
public class SignController {

    private final SignManager signManager;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = signManager.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
