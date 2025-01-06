package com.lld.splitwise.repositories;

import com.lld.splitwise.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
