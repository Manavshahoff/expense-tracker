package com.expense.tracker.expense_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.orElseThrow(() -> new RuntimeException("Expense not found with id " + id));
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Double getTotalExpenses(){
        return expenseRepository.getTotalExpenses();
    }

    @Override
    public List<Object[]> getExpensesByCategory(){
        return expenseRepository.getExpenseByCategory();

    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    @Override
    public List<Expense> getExpensesSortedByAmountAsc() {
        return expenseRepository.findAllByOrderByAmountAsc();
    }

    @Override
    public List<Expense> getExpensesSortedByAmountDesc() {
        return expenseRepository.findAllByOrderByAmountDesc();
    }

    @Override
    public List<Expense> getExpensesSortedByDateAsc() {
        return expenseRepository.findAllByOrderByDateAsc();
    }

    @Override
    public List<Expense> getExpensesSortedByDateDesc() {
        return expenseRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Page<Expense> getAllExpensesPaginated(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }





  

}
