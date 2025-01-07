package com.lld.splitwise.DTO;

import com.lld.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseCreationResponseDTO {
 private Expense expense;

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
