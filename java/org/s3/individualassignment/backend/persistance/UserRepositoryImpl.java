package org.s3.individualassignment.backend.persistance;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.Users.UserConverter;
import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.interfaces.UserRepository;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class
UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;


    @Override
    public UserEntity findBuUsername(String username) {
        return userRepositoryJPA.findByUsername(username);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepositoryJPA.findById(id).map(UserConverter::convert);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryJPA.findAll().stream().map(UserConverter::convert).toList();
    }

    @Override
    public List<User> getAllUsersWithUsername(String username) {
        return userRepositoryJPA.getAllUsersWithUsername(username).stream().map(UserConverter::convert)
                .toList();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepositoryJPA.existsByUsername(username);
    }
    @Override
    public UserEntity save(UserEntity user){
        return userRepositoryJPA.save(user);
    }
}
