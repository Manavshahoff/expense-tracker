package com.expense.tracker.expense_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    //Total expenses
    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double getTotalExpenses();

    //Expense by category
    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> getExpenseByCategory();


}
