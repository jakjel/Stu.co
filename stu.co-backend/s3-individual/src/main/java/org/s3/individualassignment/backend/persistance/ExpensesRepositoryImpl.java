package org.s3.individualassignment.backend.persistance;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.business.impl.Expenses.ExpenseConverter;
import org.s3.individualassignment.backend.business.impl.Expenses.ExpenseEntityConverter;
import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.interfaces.ExpensesRepository;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ExpensesRepositoryImpl implements ExpensesRepository {

    private final ExpensesRepositoryJPA expensesRepositoryJPA;

    @Override
    public List<Expense> getAllExpenses(){
        return expensesRepositoryJPA.findAll().stream().map(ExpenseConverter::convert).toList();
    }

    @Override
    public List<Expense> getGroupsExpenses(String groupId) {
        return expensesRepositoryJPA.getGroupExpensesByGroupId(groupId).stream().map(ExpenseConverter::convert).toList();
    }
    @Override
    public List<Expense> getUsersExpenses(String userId) {
        return expensesRepositoryJPA.getUsersExpenses(userId).stream().map(ExpenseConverter::convert).toList();
    }

    @Override
    public ExpenseEntity createExpense(Expense expense) {
        return expensesRepositoryJPA.save(ExpenseEntityConverter.convert(expense));
    }
    @Override
    public void createRecordInGroupUser(Long groupId, Long userId){
        expensesRepositoryJPA.createGroupUserRecord(groupId, userId);
    }


}
