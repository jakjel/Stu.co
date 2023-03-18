package org.s3.individualassignment.backend.business.impl.Users;

import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

public class UserConverter {
    private UserConverter(){

    }
    public static User convert(UserEntity user) {
        return User.builder()
                .id(user.getUser_id())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
