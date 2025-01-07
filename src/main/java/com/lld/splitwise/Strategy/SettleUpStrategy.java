package com.lld.splitwise.Strategy;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
