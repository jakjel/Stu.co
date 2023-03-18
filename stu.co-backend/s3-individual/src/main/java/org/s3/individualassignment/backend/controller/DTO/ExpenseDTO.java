package org.s3.individualassignment.backend.controller.DTO;

import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExpenseDTO {
    private Long id;
    private Long uot_id; //user owing to, id of the creator
    private Long group_id;
    private double amount_of_money;
    private LocalDateTime created_at;
    private String username;
    private Long user_id;
}
