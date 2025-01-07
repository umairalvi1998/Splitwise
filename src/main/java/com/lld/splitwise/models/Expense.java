package com.lld.splitwise.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

@Entity(name = "expenses")
public class Expense extends BaseModel {

    private  String description;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ExpenseUser> expenseUsers;

    public List<ExpenseUser> getExpenseUsers() {
        return expenseUsers;
    }

    public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
        this.expenseUsers = expenseUsers;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
