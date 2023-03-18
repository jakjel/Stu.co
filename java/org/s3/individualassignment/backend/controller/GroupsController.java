package org.s3.individualassignment.backend.controller;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.exceptions.UnauthorizedDataAccessException;
import org.s3.individualassignment.backend.configuration.security.isAuthenticated.IsAuthenticated1;
import org.s3.individualassignment.backend.controller.DTO.*;
import org.s3.individualassignment.backend.domain.AccessToken;
import org.s3.individualassignment.backend.domain.Group;
import org.s3.individualassignment.backend.domain.UserRole;
import org.s3.individualassignment.backend.interfaces.GroupsManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/expenses/groups")
@CrossOrigin(origins = "http://localhost:3000")
public class GroupsController {
    private final GroupsManager groupsManager;
    private AccessToken requestAccessToken;
    @GetMapping()
    public ResponseEntity<GetGroupsResponse> getGroups() {
        List<GroupDTO> groups = groupsManager.getAllGroups().stream()
                .map(GroupDTOConverter::convert)
                .toList();
        GetGroupsResponse response = new GetGroupsResponse();
        if (groups.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setGroups(groups);
        }
        return ResponseEntity.ok(response);
    }
    @IsAuthenticated1
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("{user_id}")
    public ResponseEntity<GetGroupsResponse> getGroupsByUserId(@PathVariable(value = "user_id") final Long userId) {
        if (!requestAccessToken.hasRole(UserRole.USER.name())) {
            throw new UnauthorizedDataAccessException("USER_HAS_NO_ACCESS");
        }
        List<GroupDTO> groups = groupsManager.getGroupsByUserId(userId).stream()
                .map(GroupDTOConverter::convert)
                .toList();
        GetGroupsResponse response = new GetGroupsResponse();
        if (groups.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setGroups(groups);
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping()
    public ResponseEntity<GroupDTO> createGroup(@RequestBody CreateGroupDTO group) {
        Group createdGroup = GroupDomainConverter.convert(group);
        groupsManager.save(createdGroup);
        return ResponseEntity.ok(CreateGroupDTOConverter.convert(createdGroup));
    }
}
