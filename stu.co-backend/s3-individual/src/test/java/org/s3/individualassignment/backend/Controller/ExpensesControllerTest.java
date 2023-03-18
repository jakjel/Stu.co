package org.s3.individualassignment.backend.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.s3.individualassignment.backend.controller.DTO.ExpenseDTO;
import org.s3.individualassignment.backend.controller.DTO.GetExpensesResponse;
import org.s3.individualassignment.backend.controller.ExpensesController;
import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.domain.User;
import org.s3.individualassignment.backend.interfaces.ExpensesManager;
import org.s3.individualassignment.backend.persistance.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExpensesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpensesManager expensesManager;


    @Test
    public void getAllExpenses() throws Exception {
        List<Expense> expenses = new ArrayList<Expense>();
        Expense expense1 = Expense.builder()
                .id(1L)
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .amount_of_money(10)
                .group_id(1L)
                .uot_id(1L)
                .user_id(2L)
                .user(UserEntity.builder()
                        .user_id(2L)
                        .username("daniil")
                        .build())
                .build();
        Expense expense2 = Expense.builder()
                .id(2L)
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .amount_of_money(4)
                .group_id(1L)
                .uot_id(2L)
                .user_id(1L)
                .user(UserEntity.builder()
                        .user_id(1L)
                        .username("jakjel")
                        .build())
                .build();
        expenses.add(expense1);
        expenses.add(expense2);

        when(expensesManager.getAllExpenses()).thenReturn(expenses);

        mockMvc.perform(get("/expenses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            {"expenses":[{"id":1,"uot_id":1,"group_id":1,"amount_of_money":10.0,"created_at":"2023-01-01T09:00:00","username":"daniil","user_id":2},{"id":2,"uot_id":2,"group_id":1,"amount_of_money":4.0,"created_at":"2023-01-01T09:00:00","username":"jakjel","user_id":1}]}
                        """));
        verify(expensesManager).getAllExpenses();
    }
    @Test
    public void getUsersExpenses() throws Exception {
        List<Expense> expenses = new ArrayList<Expense>();
        Expense expense1 = Expense.builder()
                .id(0L)
                .created_at(LocalDateTime.of(2023, 1, 1, 9, 00))
                .amount_of_money(0.0)
                .group_id(0L)
                .uot_id(0L)
                .user_id(0L)
                .user(UserEntity.builder()
                        .user_id(0L)
                        .username("string")
                        .build())
                .build();
        expenses.add(expense1);


        when(expensesManager.getUsersExpenses("0")).thenReturn(expenses);

        mockMvc.perform(get("/expenses/user/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("""
                            {
                              "expenses": [
                                {
                                  "id": 0,
                                  "uot_id": 0,
                                  "group_id": 0,
                                  "amount_of_money": 0.0,
                                  "created_at": "2023-01-01T09:00:00",
                                  "username": "string",
                                  "user_id": 0
                                }
                              ]
                            }
                        """));

        verify(expensesManager).getUsersExpenses("0");
    }
}
//{
//        "expenses": [
//        {
//        "id": 2,
//        "uot_id": 1,
//        "group_id": 1,
//        "amount_of_money": 10,
//        "created_at": "2023-01-13T12:01:53.685Z",
//        "username": "daniil",
//        "user_id": 2
//        }
//        ]
//        }