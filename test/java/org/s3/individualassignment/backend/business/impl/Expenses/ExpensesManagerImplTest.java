package org.s3.individualassignment.backend.business.impl.Expenses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.interfaces.ExpensesRepository;
import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ExpensesManagerImplTest {
    @Mock
    ExpensesRepository expensesRepository;
    @InjectMocks
    private ExpensesManagerImpl expensesManager;
    @Test
    public void testCreateExpense() {

        Expense expense = Expense.builder()
                .id(1L)
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .amount_of_money(10)
                .group_id(1L)
                .uot_id(1L) //user owed to
                .user_id(2L)
                .user(UserEntity.builder()
                        .user_id(2L)
                        .build())
                .build();
        ExpenseEntity createdExpense = ExpenseEntity.builder()
                .expense_id(1L)
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .amount_of_money(10)
                .group_id(1L)
                .uot_id(1L) //user owed to
                .user(UserEntity.builder()
                        .user_id(2L)
                        .build())
                .build();
        when(expensesRepository.createExpense(expense)).thenReturn(createdExpense);
        ExpenseEntity returnedExpense = expensesManager.createExpense(expense);

        verify(expensesRepository).createRecordInGroupUser(expense.getGroup_id(), expense.getUser().getUser_id());
        verify(expensesRepository).createRecordInGroupUser(expense.getGroup_id(), expense.getUot_id());

        assertEquals(createdExpense, returnedExpense);
    }
}
