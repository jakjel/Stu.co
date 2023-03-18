package org.s3.individualassignment.backend.business.impl.Groups;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.s3.individualassignment.backend.business.impl.Users.UserEntityConverter;
import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.interfaces.GroupsManager;
import org.s3.individualassignment.backend.interfaces.GroupsRepository;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class GroupsManagerImplTest {
    @Mock
    GroupsRepository groupsRepository;
    @InjectMocks
    private GroupsManagerImpl groupsManager;
    private Set<User> createUsers() {
        User user1 = User.builder()
                .id(1L)
                .build();
        User user2 = User.builder()
                .id(2L)
                .build();
        Set<User> users = new HashSet<User>();
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Test
    void getAllGroups_happyflow(){
        List<Group> expectedGroups = Arrays.asList(
                Group.builder()
                        .id(1L)
                        .group_name("Test")
                        .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                        .build(),
                Group.builder()
                        .id(2L)
                        .group_name("Test2")
                        .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                        .build());
        when(groupsRepository.getAllGroups()).thenReturn(expectedGroups);

        List<Group> actualGroups = groupsManager.getAllGroups();
        assertEquals(expectedGroups, actualGroups);
        verify(groupsRepository, times(1)).getAllGroups();
    }
    @Test
    void getGroupsByUserId_happyflow(){
        Set<User> users = createUsers();
        List<Group> expectedGroups = Arrays.asList(
                Group.builder()
                        .id(1L)
                        .group_name("Test")
                        .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                        .users(users)
                        .build(),
                Group.builder()
                        .id(2L)
                        .group_name("Test2")
                        .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                        .users(users)
                        .build());
        when(groupsRepository.getGroupsByUserId(1L)).thenReturn(expectedGroups);
        List<Group> actualGroups = groupsManager.getGroupsByUserId(1L);
        assertEquals(expectedGroups, actualGroups);
        verify(groupsRepository, times(1)).getGroupsByUserId(1L);
    }
    @Test
    public void saveGroup_happyflow() {
        Set<User> users = createUsers();
        GroupEntity groupEntity = GroupEntity.builder()
                .group_id(1L)
                .group_name("Test")
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .users(users.stream().map(UserEntityConverter::convert).collect(Collectors.toSet()))
                .build();
        when(groupsRepository.createGroup(any(Group.class))).thenReturn(groupEntity);
        Group group = Group.builder()
                .id(1L)
                .group_name("Test")
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .users(users)
                .build();
        GroupEntity returnedGroupEntity = groupsManager.save(group);
        verify(groupsRepository).createGroup(group);
        assertEquals(groupEntity, returnedGroupEntity);
    }


}
