package org.s3.individualassignment.backend.persistance;

import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
    @Query(value = "SELECT u FROM UserEntity as u WHERE u.username like %:username%")
    List<UserEntity> getAllUsersWithUsername( @Param("username") String username);
}
