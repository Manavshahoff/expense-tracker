package com.expense.tracker.expense_tracker;

import java.util.List;

public interface ExpenseService {
    Expense saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Expense expense);
    void deleteExpense(Long id);
}
