package com.lld.splitwise.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ExpenseUser extends  BaseModel {
    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonBackReference
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @Enumerated(EnumType.ORDINAL)
//    private  ExpenseUserType expenseUserType;

    private  int paidAmount;
    private  int owedAmount;

    public int getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(int owedAmount) {
        this.owedAmount = owedAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
