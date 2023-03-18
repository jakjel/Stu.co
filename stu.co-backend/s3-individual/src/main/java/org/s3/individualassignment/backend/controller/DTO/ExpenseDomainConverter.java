package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

public class ExpenseDomainConverter {
    private ExpenseDomainConverter(){

    }
    public static Expense convert(ExpenseDTO expense){
        return Expense.builder()
                .id(expense.getId())
                .uot_id(expense.getUot_id())
                .group_id(expense.getGroup_id())
                .amount_of_money(expense.getAmount_of_money())
                .created_at(expense.getCreated_at())
                .user(UserEntity.builder()
                        .user_id(expense.getUser_id())
                        .build())
                .build();
    }
}
