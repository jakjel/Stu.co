package org.s3.individualassignment.backend.interfaces;

import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;

import java.util.List;

public interface ExpensesManager {
    public List<Expense> getAllExpenses();
    public List<Expense> getGroupsExpenses(String groupId);
    public List<Expense> getUsersExpenses(String userId);
    public ExpenseEntity createExpense(Expense expense);
}
