package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;

import java.util.List;

public interface GroupsManager {
    public List<Group> getAllGroups();
    public List<Group> getGroupsByUserId(Long userId);
    public GroupEntity save(Group group);
}
