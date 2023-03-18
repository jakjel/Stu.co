package org.s3.individualassignment.backend.business.impl.Expenses;

import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;

public class ExpenseEntityConverter {
    private ExpenseEntityConverter(){

    }
    public static ExpenseEntity convert(Expense expense){
        return ExpenseEntity.builder()
                .expense_id(expense.getId())
                .uot_id(expense.getUot_id())
                .group_id(expense.getGroup_id())
                .amount_of_money(expense.getAmount_of_money())
                .created_at(expense.getCreated_at())
//                .user_id(expense.getUser_id())
                .user(expense.getUser())
                .build();
    }
}
