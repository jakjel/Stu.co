package org.s3.individualassignment.backend.controller;

import lombok.AllArgsConstructor;
import org.s3.individualassignment.backend.controller.DTO.*;
import org.s3.individualassignment.backend.domain.Expense;
import org.s3.individualassignment.backend.interfaces.ExpensesManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpensesController {

    private final ExpensesManager expensesManager;
    @GetMapping("{group_id}")
    public ResponseEntity<GetExpensesResponse> getGroupsExpenses(@PathVariable(value = "group_id") final String groupId) {
        List<ExpenseDTO> groupsExpenses = expensesManager.getGroupsExpenses(groupId).stream()
                .map(ExpenseDTOConverter::convert)
                .toList();
        GetExpensesResponse response = new GetExpensesResponse();
        if (groupsExpenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setExpenses(groupsExpenses);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/user/{user_id}")
    public ResponseEntity<GetExpensesResponse> getUsersExpenses(@PathVariable(value = "user_id") final String userId) {
        List<ExpenseDTO> groupsExpenses = expensesManager.getUsersExpenses(userId).stream()
                .map(ExpenseDTOConverter::convert)
                .toList();
        GetExpensesResponse response = new GetExpensesResponse();
        if (groupsExpenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setExpenses(groupsExpenses);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping()
    public ResponseEntity<GetExpensesResponse> getAllExpenses() {
        List<ExpenseDTO> groupsExpenses = expensesManager.getAllExpenses().stream()
                .map(ExpenseDTOConverter::convert)
                .toList();
        GetExpensesResponse response = new GetExpensesResponse();
        if (groupsExpenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            response.setExpenses(groupsExpenses);
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping()
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expense) {
        Expense createdExpense = ExpenseDomainConverter.convert(expense);
        expensesManager.createExpense(createdExpense);
        return ResponseEntity.ok(ExpenseDTOConverter.convert(createdExpense));
    }

}
