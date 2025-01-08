package com.lld.splitwise.Strategy;

import com.lld.splitwise.models.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        //we need to find the total balance for each person involved in the expense
        /*
        for each person find all the expenses and then calculate paid-owed
         */
        //default order is ascending
        Group group = expenses.get(0).getGroup();
        ArrayList<Transaction> transactions = new ArrayList<>();
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
            UserAmount maxLendor = maxHeap.poll();
            UserAmount maxBorrower = minHeap.poll();

            if(maxLendor.getAmount() > Math.abs(maxBorrower.getAmount())) { //Borrower will settle up
                Transaction transaction =
                        new Transaction(Math.abs(maxBorrower.getAmount()), Arrays.asList(maxBorrower.getUser(), maxLendor.getUser()), group);
                transactions.add(transaction);
                maxLendor.setAmount(maxLendor.getAmount() - Math.abs(maxBorrower.getAmount()));
                maxHeap.add(maxLendor);
            }
            else if(maxLendor.getAmount() < Math.abs(maxBorrower.getAmount())) { //Lendor will settle up
                Transaction transaction =
                        new Transaction(maxLendor.getAmount(), Arrays.asList(maxBorrower.getUser(), maxLendor.getUser()), group);
                transactions.add(transaction);
                maxBorrower.setAmount(Math.abs(maxLendor.getAmount() - Math.abs(maxBorrower.getAmount())));
                minHeap.add(maxBorrower);
            }
            else {
                Transaction transaction =
                        new Transaction(maxLendor.amount, Arrays.asList(maxBorrower.getUser(), maxLendor.getUser()), group);
                transactions.add(transaction);
            }

        }



        return transactions;
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
            this.amount = amount;

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
