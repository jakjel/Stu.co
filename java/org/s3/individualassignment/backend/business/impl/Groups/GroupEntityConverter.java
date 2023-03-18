package org.s3.individualassignment.backend.business.impl.Groups;


import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;


public class GroupEntityConverter {
    private GroupEntityConverter(){

    }
    public static GroupEntity convert(Group group){
        return GroupEntity.builder()
                .group_id(group.getId())
                .group_name(group.getGroup_name())
                .created_at(group.getCreated_at())
                .build();
    }
}
