package org.s3.individualassignment.backend.controller.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateGroupDTO {
    private Long id;
    private String group_name;
    private LocalDateTime created_at;
}
