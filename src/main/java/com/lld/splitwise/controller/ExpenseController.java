package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.ExpenseCreationRequestDto;
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
    public ResponseEntity addExpense(@RequestBody ExpenseCreationRequestDto expenseCreationRequestDto) {
        return ResponseEntity.ok(expenseService.createExpense(expenseCreationRequestDto));
    }
}
