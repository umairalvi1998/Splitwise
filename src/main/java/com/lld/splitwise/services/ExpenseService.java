package com.lld.splitwise.services;

import com.lld.splitwise.DTO.ExpenseCreationRequestDto;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.repositories.ExpenseRepository;
import com.lld.splitwise.repositories.ExpenseUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    ExpenseRepository expenseRepository;
    ExpenseUserRepository expenseUserRepository;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseUserRepository expenseUserRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public Expense createExpense(ExpenseCreationRequestDto expenseCreationRequestDto) {
        return null;
    }
}
