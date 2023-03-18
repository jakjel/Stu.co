package org.s3.individualassignment.backend.domain;

import lombok.*;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Expense {
    private Long id;
    private Long user_id;
    private Long uot_id; //user owing to, id of the creator
    private Long group_id;
    private double amount_of_money;
    private LocalDateTime created_at;
    private UserEntity user;
}
