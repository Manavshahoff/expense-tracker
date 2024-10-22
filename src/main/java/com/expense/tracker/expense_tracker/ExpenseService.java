package com.expense.tracker.expense_tracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    Expense saveExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Expense expense);
    void deleteExpense(Long id);
    Double getTotalExpenses();
    List<Object[]> getExpensesByCategory();
    List<Expense> getExpensesByCategory(String category);
    List<Expense> getExpensesSortedByAmountAsc();
    List<Expense> getExpensesSortedByAmountDesc();
    List<Expense> getExpensesSortedByDateAsc();
    List<Expense> getExpensesSortedByDateDesc();
    Page<Expense> getAllExpensesPaginated(Pageable pageable);



}
