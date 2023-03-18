package org.s3.individualassignment.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
public class Group {
    private Long id;
    private String group_name;
    private LocalDateTime created_at;
    private Set<User> users;
}
