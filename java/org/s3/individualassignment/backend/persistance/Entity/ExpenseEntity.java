package org.s3.individualassignment.backend.persistance.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expense_id;
//    @NotBlank
    @Column(name = "uot_id")
    private Long uot_id; //user owing to, id of the creator
//    @NotBlank
    @Column(name = "group_id")
    private Long group_id;
//    @NotBlank
    @Column(name = "amount_of_money")
    private double amount_of_money;
//    @NotBlank
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
}
