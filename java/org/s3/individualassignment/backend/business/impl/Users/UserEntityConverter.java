package org.s3.individualassignment.backend.business.impl.Users;

import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

public class UserEntityConverter {
    private UserEntityConverter(){

    }
    public static UserEntity convert(User user) {
        return UserEntity.builder()
                .user_id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
