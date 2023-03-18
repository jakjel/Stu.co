package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.Group;

import java.util.stream.Collectors;

public class GroupDTOConverter {
    private GroupDTOConverter(){

    }
    public static GroupDTO convert(Group group){
        return GroupDTO.builder()
                .id(group.getId())
                .group_name(group.getGroup_name())
                .created_at(group.getCreated_at())
                .users(group.getUsers().stream().map(UserDTOConverter::convert).collect(Collectors.toSet()))
                .build();
    }

}
