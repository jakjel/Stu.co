package org.s3.individualassignment.backend.controller.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
public class GetAllUsersResponse {
    @Setter
    @Getter
    private List<UserDTO> users;
}
