package org.s3.individualassignment.backend.business.impl.Expenses;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.interfaces.ExpensesManager;
import org.s3.individualassignment.backend.interfaces.ExpensesRepository;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ExpensesManagerImpl implements ExpensesManager {
    private final ExpensesRepository expensesRepository;

    public List<Expense> getAllExpenses(){
        return expensesRepository.getAllExpenses();
    }
    public List<Expense> getGroupsExpenses(String groupId){
        return expensesRepository.getGroupsExpenses(groupId);
    }
    public List<Expense> getUsersExpenses(String userId){
        return expensesRepository.getUsersExpenses(userId);
    }

    @Override
    public ExpenseEntity createExpense(Expense expense) {
        ExpenseEntity createdExpense =  expensesRepository.createExpense(expense);
        expensesRepository.createRecordInGroupUser(expense.getGroup_id(), expense.getUser().getUser_id());
        expensesRepository.createRecordInGroupUser(expense.getGroup_id(), expense.getUot_id());
        return createdExpense;
    }
}
