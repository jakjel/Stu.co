package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.Group;


public class CreateGroupDTOConverter {
    private CreateGroupDTOConverter(){

    }
    public static GroupDTO convert(Group group){
        return GroupDTO.builder()
                .id(group.getId())
                .group_name(group.getGroup_name())
                .created_at(group.getCreated_at())
                .build();
    }
}
