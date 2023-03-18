package org.s3.individualassignment.backend.business.impl.Users;

import lombok.RequiredArgsConstructor;
import org.s3.individualassignment.backend.business.impl.exceptions.UsernameAlreadyExistsException;
import org.s3.individualassignment.backend.domain.CreateUserRequest;
import org.s3.individualassignment.backend.domain.CreateUserResponse;
import org.s3.individualassignment.backend.domain.UserRole;
import org.s3.individualassignment.backend.interfaces.UserRepository;
import org.s3.individualassignment.backend.interfaces.UsersManager;
import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class UsersManagerImpl implements UsersManager{
    private final UserRepository userRepository; //novy repository
    private final PasswordEncoder passwordEncoder;

    //get user by id
    @Transactional //new
    @Override
    public Optional<User> getUser(long userId) { //why optional?
        return userRepository.findById(userId);
    }
    //get users list
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    @Transactional
    @Override
    public List<User> searchUsersByUsername(String username) {
        return userRepository.getAllUsersWithUsername(username);
    }

    @Transactional
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException(); //need to create custom one
        }
        UserEntity savedUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .userId(savedUser.getUser_id())
                .build();
    }

    private UserEntity saveNewUser(CreateUserRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword()); //tady dopice, tady se to deje, tady se nam vytvari to zasrany heslo

        UserEntity newUser = UserEntity.builder()
                .username(request.getUsername()) //tady se vytvari to zasrany username
                .password(encodedPassword)
                .email(request.getEmail())
                .firstName(request.getFirst_name())
                .lastName(request.getLast_name())
                .role(UserRole.USER)
                .build();
        userRepository.save(newUser);
        return newUser;
    }

}
