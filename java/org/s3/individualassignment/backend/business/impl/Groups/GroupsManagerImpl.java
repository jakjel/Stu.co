package org.s3.individualassignment.backend.business.impl.Groups;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.interfaces.GroupsManager;
import org.s3.individualassignment.backend.interfaces.GroupsRepository;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class GroupsManagerImpl implements GroupsManager {

    private final GroupsRepository groupsRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupsRepository.getAllGroups();
    }

    @Override
    public List<Group> getGroupsByUserId(Long userId) {
        return groupsRepository.getGroupsByUserId(userId);
    }

    @Override
    public GroupEntity save(Group group) {
        return groupsRepository.createGroup(group);
    }
}
