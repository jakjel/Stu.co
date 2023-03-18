package org.s3.individualassignment.backend.business.impl.Expenses;

import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;

public class ExpenseConverter {
    private ExpenseConverter(){

    }
    public static Expense convert(ExpenseEntity expense){
        return Expense.builder()
                .id(expense.getExpense_id())
                .uot_id(expense.getUot_id())
                .group_id(expense.getGroup_id())
                .amount_of_money(expense.getAmount_of_money())
                .created_at(expense.getCreated_at())
                .user(expense.getUser())
                .user_id(expense.getUser().getUser_id())
                .build();
    }
}
