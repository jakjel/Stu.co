package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.User;

public class UserDomainConverter {
    private UserDomainConverter(){

    }
    public static User convert(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
