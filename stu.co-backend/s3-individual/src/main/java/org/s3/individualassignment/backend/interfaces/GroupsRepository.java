package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;

import java.util.List;

public interface GroupsRepository {
    List<Group> getAllGroups();
    List<Group> getGroupsByUserId(Long userId);
    GroupEntity createGroup(Group group);
}
