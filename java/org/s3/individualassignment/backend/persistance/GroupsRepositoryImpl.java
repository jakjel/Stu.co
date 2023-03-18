package org.s3.individualassignment.backend.persistance;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.Groups.GroupConverter;
import org.s3.individualassignment.backend.business.impl.Groups.GroupEntityConverter;
import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.interfaces.GroupsRepository;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor

public class GroupsRepositoryImpl implements GroupsRepository {

    private final GroupsRepositoryJPA groupsRepositoryJPA;

    @Override
    public List<Group> getAllGroups() {
        return groupsRepositoryJPA.findAll().stream().map(GroupConverter::convert).toList();
    }

    @Override
    public List<Group> getGroupsByUserId(Long userId) {
        return groupsRepositoryJPA.findGroupsByUser(userId).stream().map(GroupConverter::convert).toList();
    }

    @Override
    public GroupEntity createGroup(Group group) {
        return groupsRepositoryJPA.save(GroupEntityConverter.convert(group));
    }
}
