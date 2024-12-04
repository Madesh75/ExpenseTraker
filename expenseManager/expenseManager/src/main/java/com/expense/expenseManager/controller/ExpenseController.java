package com.expense.expenseManager.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.expense.expenseManager.model.Expense;
import com.expense.expenseManager.service.ExpenseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/category")
    public List<Expense> getExpensesByCategory(@RequestParam String category) {
        return expenseService.getExpensesByCategory(category);
    }

    @GetMapping("/report")
    public List<Expense> getExpensesByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return expenseService.getExpensesBetweenDates(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
