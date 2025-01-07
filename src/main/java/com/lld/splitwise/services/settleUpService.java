package com.lld.splitwise.services;

import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.Strategy.SettleUpStrategy;
import com.lld.splitwise.models.*;
import com.lld.splitwise.repositories.ExpenseUserRepository;
import org.springframework.stereotype.Service;
import com.lld.splitwise.repositories.groupRepository;
import com.lld.splitwise.repositories.userRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class settleUpService {

    private userRepository userRepository;
    private groupRepository groupRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;

    public settleUpService(userRepository userRepository, groupRepository groupRepository, ExpenseUserRepository expenseUserRepository, SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) throws userNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new userNotFoundException("User not found");
        }

        User user = optionalUser.get();

        //fetch all the expenses where this user was part of.
        List<ExpenseUser> expenses = expenseUserRepository.findByUser(user);
        Set<Expense> expensesToSettle = new HashSet<>(); // this is because we don't want to settle the same expense twice. a user can be "paidBy" and "hadToPay" in a single expense
        for(ExpenseUser expenseUser : expenses) {
                expensesToSettle.add(expenseUser.getExpense());
        }

        List<Transaction>  transactions = settleUpStrategy.settleUp(expensesToSettle.stream().toList());

        return  transactions;
                //transactions.stream().filter(expense -> expense.getExpenseUsers().stream().anyMatch(expenseUser -> expenseUser.getUser().equals(user))).toList();

    }

    public List<Transaction> settleUpGroup(Long groupId) throws GroupNotFoundException {
         Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found"));
         List<Expense> expenses = group.getExpenses();
         List<Transaction>  transactions = settleUpStrategy.settleUp(expenses);
         System.out.println("transactions = " + transactions);
         return transactions;
    }
}
