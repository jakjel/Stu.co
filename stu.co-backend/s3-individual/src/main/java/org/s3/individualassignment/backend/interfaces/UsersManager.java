package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.CreateUserRequest;
import org.s3.individualassignment.backend.domain.CreateUserResponse;
import org.s3.individualassignment.backend.domain.User;

import java.util.List;
import java.util.Optional;

public interface UsersManager {
    public Optional<User> getUser(long userId);
    public List<User> getAllUsers();
    public List<User>searchUsersByUsername(String username);
    CreateUserResponse createUser(CreateUserRequest request);
}
