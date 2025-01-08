package com.lld.splitwise.Strategy;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expenses);
}
