package com.expense.expenseManager.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenseManager.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}