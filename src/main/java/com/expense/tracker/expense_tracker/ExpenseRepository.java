package com.expense.tracker.expense_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    //Total expenses
    @Query("SELECT SUM(e.amount) FROM Expense e")
    Double getTotalExpenses();

    //Expense by category
    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> getExpenseByCategory();

    //Return all individual expense record that match specific category
    @Query("SELECT e FROM Expense e WHERE e.category = :category")
    List<Expense> findByCategory(@Param("category") String category);

    //Sort expense by amount
    List<Expense> findAllByOrderByAmountAsc();
    List<Expense> findAllByOrderByAmountDesc();

    //Sort expense by date asec and dec
    List<Expense> findAllByOrderByDateAsc();
    List<Expense> findAllByOrderByDateDesc();

    //Pagination method(Fetching limited page. E.g "10 expenses at a time")
    Page<Expense> findAll(Pageable pageable);







}
