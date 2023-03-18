//package org.s3.individualassignment.backend.repository;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.s3.individualassignment.backend.domain.UserRole;
//import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
//import org.s3.individualassignment.backend.persistance.UserRepositoryJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
//public class UserRepositoryTest {
//    @Autowired
//    private EntityManager entityManager;
//    @Autowired
//    private UserRepositoryJPA userRepositoryJPA;
//    @Test
//    void save_shouldSaveUserWithAllFields() {
//        //vytvorim usera
//        UserEntity userP = UserEntity.builder()
//                .user_id(100L)
//                .username("jelinejak")
//                .email("jelinej2012@gmail.com")
//                .password("test")
//                .firstName("Jakub")
//                .lastName("Jelinek")
//                .role(UserRole.USER)
//                .build();
//
//        UserEntity savedUser = userRepositoryJPA.save(userP); //ulozim pomoci repository, tohle je to co chci otestovay
//        assertNotNull(savedUser.getUser_id()); //checknu jetli neni user nulovej
//
//        savedUser = entityManager.find(UserEntity.class, savedUser.getUser_id()); //vratim usera
//        UserEntity expectedUser = UserEntity.builder()
//                .user_id(savedUser.getUser_id())
//                .username("jelinejak")
//                .email("jelinej2012@gmail.com")
//                .password("test")
//                .firstName("Jakub")
//                .lastName("Jelinek")
//                .role(UserRole.USER)
//                .build();
//        assertEquals(expectedUser, savedUser);
//    }
//}
