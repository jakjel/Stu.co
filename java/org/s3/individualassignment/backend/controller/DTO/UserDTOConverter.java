package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.User;

public class UserDTOConverter {
    private UserDTOConverter(){

    }
    public static UserDTO convert(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
