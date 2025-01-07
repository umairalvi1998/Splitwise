package com.lld.splitwise.services;

import com.lld.splitwise.DTO.ExpenseCreationRequestDto;
import com.lld.splitwise.DTO.PayoutDTO;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.*;
import com.lld.splitwise.repositories.ExpenseRepository;
import com.lld.splitwise.repositories.ExpenseUserRepository;
import com.lld.splitwise.repositories.groupRepository;
import com.lld.splitwise.repositories.userRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private userRepository userRepo;
    private ExpenseRepository expenseRepo;
    private ExpenseUserRepository expenseUserRepo;
    private groupRepository groupRepo;

    ExpenseService(userRepository userRepo, ExpenseRepository expenseRepo, ExpenseUserRepository expenseUserRepo,groupRepository groupRepo) {
        this.userRepo = userRepo;
        this.expenseRepo = expenseRepo;
        this.expenseUserRepo = expenseUserRepo;
        this.groupRepo = groupRepo;

    }
    @Transactional
    public Expense createExpense(ExpenseCreationRequestDto expenseCreationRequestDto) throws userNotFoundException, GroupNotFoundException {
        Expense expense = new Expense();
        int amount = expenseCreationRequestDto.getAmount();
        expense.setAmount(amount);
        String description = expenseCreationRequestDto.getDescription();
        expense.setDescription(description);
        Long userId = expenseCreationRequestDto.getUserId();
        Optional<User> userOptional = userRepo.findById(userId);
        Group group = groupRepo.findById(expenseCreationRequestDto.getGroupId()).orElseThrow(()->new GroupNotFoundException("Group Not found with the given Id"));
        if(userOptional.isEmpty()) {
            throw new userNotFoundException("User Not found with the given Id");
        }
        User user = userOptional.get();
        expense.setCreatedBy(user);
        expense.setGroup(group);
        expense.setExpenseType(ExpenseType.REAL);
        expenseRepo.save(expense);
        List<ExpenseUser> expenseUsers = new ArrayList<ExpenseUser>();
        for(PayoutDTO payout : expenseCreationRequestDto.getPayoutDTOS()) {

            ExpenseUser expenseUser = new ExpenseUser();
            Integer userid = payout.getUserId();
            User user1 = userRepo.findById(userId).orElseThrow(()->new userNotFoundException("User Not found with the given Id"));
            Integer paidAmount = payout.getPaidAmount();
            Integer owedAmount = payout.getOwedAmount();

            expenseUser.setExpense(expense);
            expenseUser.setUser(user1);
            expenseUser.setPaidAmount(paidAmount);
            expenseUser.setOwedAmount(owedAmount);

            expenseUserRepo.save(expenseUser);



        }

        expense.setExpenseUsers(expenseUsers);

        return expenseRepo.save(expense);
    }
}
















//if(paidAmount > 0  && owedAmount > 0) {
//ExpenseUser expenseUser1 = new ExpenseUser();
//                expenseUser1.setUser(user1);
//                expenseUser1.setExpense(expense);
//                expenseUser1.setAmount(paidAmount);
//                expenseUser1.setExpenseUserType(ExpenseUserType.PAID_BY);
//                expenseUserRepo.save(expenseUser1);
//
//                expenseUser.setExpense(expense);
//                expenseUser.setUser(user1);
//                expenseUser.setAmount(owedAmount);
//                expenseUser.setExpenseUserType(ExpenseUserType.HAD_TO_PAY);
//                expenseUserRepo.save(expenseUser);
//
//                expenseUsers.add(expenseUser1);
//                expenseUsers.add(expenseUser);
//
//            }
//                    else if( paidAmount>0 ) {
//        expenseUser.setExpense(expense);
//                expenseUser.setUser(user1);
//                expenseUser.setAmount(paidAmount);
//                expenseUser.setExpenseUserType(ExpenseUserType.PAID_BY);
//                expenseUsers.add(expenseUser);
//                expenseUserRepo.save(expenseUser);
//            }
//                    else if(owedAmount > 0) {
//        expenseUser.setExpense(expense);
//                expenseUser.setUser(user1);
//                expenseUser.setAmount(owedAmount);
//                expenseUser.setExpenseUserType(ExpenseUserType.HAD_TO_PAY);
//                expenseUsers.add(expenseUser);
//                expenseUserRepo.save(expenseUser);
//            }
//                    else {
//                    expenseUser.setExpense(expense);
//                expenseUser.setUser(user1);
//                expenseUser.setAmount(0);
//                expenseUser.setExpenseUserType(ExpenseUserType.HAD_TO_PAY);
//                expenseUsers.add(expenseUser);
//                expenseUserRepo.save(expenseUser);
//            }