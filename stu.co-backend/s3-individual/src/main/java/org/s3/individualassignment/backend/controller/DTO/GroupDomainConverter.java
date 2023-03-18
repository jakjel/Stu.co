package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.Group;


public class GroupDomainConverter {
    private GroupDomainConverter(){

    }
    public static Group convert(CreateGroupDTO group){
        return Group.builder()
                .id(group.getId())
                .group_name(group.getGroup_name())
                .created_at(group.getCreated_at())
                .build();
    }
}
