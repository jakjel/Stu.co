package org.s3.individualassignment.backend.controller;



import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.exceptions.UnauthorizedDataAccessException;
import org.s3.individualassignment.backend.configuration.security.isAuthenticated.IsAuthenticated1;
import org.s3.individualassignment.backend.domain.AccessToken;
import org.s3.individualassignment.backend.domain.CreateUserRequest;
import org.s3.individualassignment.backend.domain.CreateUserResponse;
import org.s3.individualassignment.backend.domain.UserRole;
import org.s3.individualassignment.backend.interfaces.UsersManager;
import org.s3.individualassignment.backend.controller.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UsersManager usersManager;
    private AccessToken requestAccessToken;

    //retrieve user by giving id as parameter
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") final long id) {
        if (!requestAccessToken.hasRole(UserRole.USER.name())) {
            if (requestAccessToken.getUserId() != id) {
                throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }
        final Optional<UserDTO> userOptional = usersManager.getUser(id).map(UserDTOConverter::convert);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOptional.get());
    }

    //retrieves list of users
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all")
    public ResponseEntity<GetAllUsersResponse> getAllUsers() {
        if (!requestAccessToken.hasRole(UserRole.USER.name()) && !requestAccessToken.hasRole(UserRole.ADMIN.name())) {
            throw new UnauthorizedDataAccessException("USER_HAS_NO_ACCESS");
        }
        List<UserDTO> allUsers = usersManager.getAllUsers().stream().map(UserDTOConverter::convert).toList();
        GetAllUsersResponse response = new GetAllUsersResponse();
        if (allUsers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setUsers(allUsers);
        }
        return ResponseEntity.ok(response);
    }
    //retrieves password by giving id as parameter, it gives null because it is not save and i only wanted to try
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping()
    public ResponseEntity<String> getUsersUsername(@RequestParam(value = "id", required = false) long id) {
        if (!requestAccessToken.hasRole(UserRole.USER.name())) {
            throw new UnauthorizedDataAccessException("USER_HAS_NO_ACCESS");
        }
        final Optional<UserDTO> userOptional = usersManager.getUser(id).map(UserDTOConverter::convert);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(userOptional.get().getUsername());
        }

    }
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/all/{username}")
    public ResponseEntity<GetAllUsersResponse> getAllUsersByUsername(@PathVariable(value = "username") final String username) {
        if (!requestAccessToken.hasRole(UserRole.USER.name())) {
            throw new UnauthorizedDataAccessException("USER_HAS_NO_ACCESS");
        }
        List<UserDTO> allUsers = usersManager.searchUsersByUsername(username).stream()
                .map(UserDTOConverter::convert)
                .toList();
        GetAllUsersResponse response = new GetAllUsersResponse();
        if (allUsers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setUsers(allUsers);
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<CreateUserResponse> createStudent(@RequestBody @Valid CreateUserRequest request) {
        CreateUserResponse response = usersManager.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
