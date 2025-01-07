package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.ExpenseCreationRequestDto;
import com.lld.splitwise.DTO.ExpenseCreationResponseDTO;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.services.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expense")
    public ResponseEntity<Object> addExpense(@RequestBody ExpenseCreationRequestDto expenseCreationRequestDto) throws userNotFoundException, GroupNotFoundException {
        ExpenseCreationResponseDTO responseDTO = new ExpenseCreationResponseDTO();
        Expense expense = expenseService.createExpense(expenseCreationRequestDto);
        responseDTO.setExpense(expense);
        return ResponseEntity.ok(responseDTO);
    }
}
