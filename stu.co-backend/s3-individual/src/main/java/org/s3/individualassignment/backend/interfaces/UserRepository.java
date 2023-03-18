package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    public UserEntity findBuUsername(String username);
    public Optional<User> findById(long id);
    public List<User> getAllUsers();
    public List<User> getAllUsersWithUsername(String username);
    public boolean existsByUsername(String username);
    public UserEntity save(UserEntity user);
}
