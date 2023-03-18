package org.s3.individualassignment.backend.business.impl.Groups;

import org.s3.individualassignment.backend.business.impl.Users.UserConverter;
import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;

import java.util.stream.Collectors;

public class GroupConverter {
    private GroupConverter(){

    }
    public static Group convert(GroupEntity group){
        return Group.builder()
                .id(group.getGroup_id())
                .group_name(group.getGroup_name())
                .created_at(group.getCreated_at())
                .users(group.getUsers().stream().map(UserConverter::convert).collect(Collectors.toSet()))
                .build();
    }
}
