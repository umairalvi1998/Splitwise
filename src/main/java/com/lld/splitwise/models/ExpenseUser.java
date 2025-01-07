package com.lld.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ExpenseUser extends  BaseModel {
    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @Enumerated(EnumType.ORDINAL)
//    private  ExpenseUserType expenseUserType;

    private  int paidAmount;
    private  int owedAmount;

}
