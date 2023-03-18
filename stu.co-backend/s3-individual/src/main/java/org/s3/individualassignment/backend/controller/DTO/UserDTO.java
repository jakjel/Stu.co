package org.s3.individualassignment.backend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.s3.individualassignment.backend.domain.UserRole;

@Builder
@AllArgsConstructor
public class UserDTO {
    @Getter
    private Long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    private UserRole role;
}
