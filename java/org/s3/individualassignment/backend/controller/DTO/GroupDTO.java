package org.s3.individualassignment.backend.controller.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDTO {
    private Long id;
    private String group_name;
    private LocalDateTime created_at;
    private Set<UserDTO> users;
}
