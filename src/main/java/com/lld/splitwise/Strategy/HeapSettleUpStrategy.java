package com.lld.splitwise.Strategy;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.ExpenseUser;
import com.lld.splitwise.models.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //we need to find the total balance for each person involved in the expense
        /*
        for each person find all the expenses and then calculate paid-owed
         */
        //default order is ascending
        Comparator<UserAmount> minUserAmountComparator = Comparator.comparingInt(UserAmount::getAmount);
        Comparator<UserAmount> maxUserAmountComparator = Comparator.comparingInt(UserAmount::getAmount).reversed();

        PriorityQueue<UserAmount> minHeap = new PriorityQueue<>(minUserAmountComparator);
        PriorityQueue<UserAmount> maxHeap = new PriorityQueue<>(maxUserAmountComparator);

        //Now start filling the Heap
        for(Map.Entry<User,Integer> entry : getTotalOutstandingBalance(expenses).entrySet() ) {
            if(entry.getValue() < 0) {
                minHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            }
            else if(entry.getValue() > 0) {
                maxHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            }
            else {
                System.out.println("User is Already Settled");
            }
        }

        while(!(maxHeap.isEmpty() || minHeap.isEmpty())) {

        }



        return null;
    }

    private  static HashMap<User,Integer> getTotalOutstandingBalance(List<Expense> expenses) {
        HashMap<User,Integer> totalOutstandingExpensesByaUser = new HashMap<User,Integer>(); //this map is supposed to store the total outstanding balance for a user in the group
        for (Expense expense : expenses) {
            for(ExpenseUser expenseUser : expense.getExpenseUsers()) {
                User user = expenseUser.getUser();
                if(totalOutstandingExpensesByaUser.containsKey(user)) {
                    Integer currentBalance = totalOutstandingExpensesByaUser.get(user);
                    currentBalance += expenseUser.getPaidAmount()-expenseUser.getOwedAmount();
                    totalOutstandingExpensesByaUser.put(user, currentBalance);
                }
                else {
                    totalOutstandingExpensesByaUser.put(user, expenseUser.getPaidAmount()-expenseUser.getOwedAmount());
                }
            }

        }
        return totalOutstandingExpensesByaUser;
    }

    private static class UserAmount {
        User user;
        Integer amount;

        public UserAmount(User user, Integer amount) {
            this.user = user;

        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Integer getAmount() {
            return amount;
        }
        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }
}
