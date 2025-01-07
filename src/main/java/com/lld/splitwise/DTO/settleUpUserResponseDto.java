package com.lld.splitwise.DTO;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class settleUpUserResponseDto {
    private List<Transaction> expenses; // dummy expenses.

    public List<Transaction> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Transaction> expenses) {
        this.expenses = expenses;
    }
}
