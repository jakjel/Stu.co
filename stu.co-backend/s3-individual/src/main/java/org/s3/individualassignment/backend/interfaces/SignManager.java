package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.LoginRequest;
import org.s3.individualassignment.backend.domain.LoginResponse;

public interface SignManager {
    LoginResponse login(LoginRequest loginRequest);
}
