package org.s3.individualassignment.backend.controller.DTO;

import org.s3.individualassignment.backend.domain.Expense;

public class ExpenseDTOConverter {
    private ExpenseDTOConverter(){

    }
    public static ExpenseDTO convert(Expense expense){
        return ExpenseDTO.builder()
                .id(expense.getId())
                .uot_id(expense.getUot_id())
                .group_id(expense.getGroup_id())
                .amount_of_money(expense.getAmount_of_money())
                .created_at(expense.getCreated_at())
                .username(expense.getUser().getUsername())
                .user_id(expense.getUser().getUser_id())
                .build();
    }
}
