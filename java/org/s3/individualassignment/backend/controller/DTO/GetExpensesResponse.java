package org.s3.individualassignment.backend.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GetExpensesResponse {
    private List<ExpenseDTO> expenses;
}
