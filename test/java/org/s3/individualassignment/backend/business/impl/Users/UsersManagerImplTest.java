package org.s3.individualassignment.backend.business.impl.Users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.s3.individualassignment.backend.business.impl.exceptions.UsernameAlreadyExistsException;
import org.s3.individualassignment.backend.domain.CreateUserRequest;
import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.domain.UserRole;
import org.s3.individualassignment.backend.interfaces.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersManagerImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UsersManagerImpl usersManager;

    @Test
    void return_getUser() {
        Optional<User> user = Optional.ofNullable(User.builder().id(1L).username("jakjel").email("jelinej2012@gmail.com").firstName("Jakub").lastName("Jelinek").password("test").role(UserRole.USER).build());
        when(userRepositoryMock.findById(1L))
                .thenReturn(user);

        Optional<User> actualResult = usersManager.getUser(1L);

        Optional<User> expectedResult = Optional.ofNullable(User.builder().id(1L).username("jakjel").email("jelinej2012@gmail.com").firstName("Jakub").lastName("Jelinek").password("test").role(UserRole.USER).build());

        assertEquals(expectedResult, actualResult);
        verify(userRepositoryMock).findById(1L);
    }

    @Test
    void getAllUsers() {
        List<User> users = new ArrayList<User>();
            users.add(User.builder().id(1L).username("jakjel").email("jelinej2012@gmail.com").firstName("Jakub").lastName("Jelinek").password("test").role(UserRole.USER).build());
            users.add(User.builder().id(2L).username("jakjel2").email("jelinej2012@gmail.com2").firstName("Jakub2").lastName("Jelinek2").password("test2").role(UserRole.USER).build());
        when(userRepositoryMock.getAllUsers().stream().toList()).thenReturn(users);

        List<User> actualResultList = userRepositoryMock.getAllUsers();
        List<User> expectedResultList = users;

        assertEquals(expectedResultList, actualResultList);
        verify(userRepositoryMock).getAllUsers();
    }
//
    @Test
    void searchUsersByUsername() {
        List<User> users = new ArrayList<>();
            users.add(User.builder().id(1L).username("jakjel").email("jelinej2012@gmail.com").firstName("Jakub").lastName("Jelinek").password("test").role(UserRole.USER).build());
            users.add(User.builder().id(2L).username("jakjel2").email("jelinej2012@gmail.com2").firstName("Jakub2").lastName("Jelinek2").password("test2").role(UserRole.USER).build());
            when(userRepositoryMock.getAllUsersWithUsername("jak").stream().toList())
                .thenReturn(users);

        List<User> actualResultList = userRepositoryMock.getAllUsersWithUsername("jak").stream().toList();
        List<User> expectedResultList = new ArrayList<>();
        expectedResultList.add(User.builder().id(1L).username("jakjel").email("jelinej2012@gmail.com").firstName("Jakub").lastName("Jelinek").password("test").role(UserRole.USER).build());
        expectedResultList.add(User.builder().id(2L).username("jakjel2").email("jelinej2012@gmail.com2").firstName("Jakub2").lastName("Jelinek2").password("test2").role(UserRole.USER).build());

        assertEquals(expectedResultList, actualResultList);
        verify(userRepositoryMock).getAllUsersWithUsername("jak");
    }

    @Test
    void createUser() {
        when(userRepositoryMock.existsByUsername("jakjel")).thenReturn(true);

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .username("jakjel")
                .build();

        UsernameAlreadyExistsException exceptionThrown = assertThrows(UsernameAlreadyExistsException.class, () -> {
            usersManager.createUser(createUserRequest);
        });
        assertEquals("400 BAD_REQUEST \"USERNAME_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(userRepositoryMock).existsByUsername("jakjel");
    }
}