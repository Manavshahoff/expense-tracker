package com.expense.tracker.expense_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id); // Ensure the ID is set before updating
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    //Endpoint to get total expenses
    @GetMapping("/total")
    public Double gettotalExpenses() {
        return expenseService.getTotalExpenses();
    }

    //Endpoint to get total expenses by category
    @GetMapping("/by-category")
    public List<Object[]> getExpenseByCategory() {
        return expenseService.getExpensesByCategory();
    }

    //Endpoint to get all expeneses realted to particular category
    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseService.getExpensesByCategory(category);
    }

    //Endpoint to get sorted expenses in assec and decend order by amount
    @GetMapping("/sorted/amount/asc")
    public List<Expense> getExpensesSortedByAmountAsc() {
        return expenseService.getExpensesSortedByAmountAsc();
    }

    @GetMapping("/sorted/amount/desc")
    public List<Expense> getExpensesSortedByAmountDesc() {
        return expenseService.getExpensesSortedByAmountDesc();
    }

    //Endpoint to get sorted expenses in assec and decend order by date
    @GetMapping("/sorted/date/asc")
    public List<Expense> getExpensesSortedByDateAsc() {
        return expenseService.getExpensesSortedByDateAsc();
    }

    @GetMapping("/sorted/date/desc")
    public List<Expense> getExpensesSortedByDateDesc() {
        return expenseService.getExpensesSortedByDateDesc();
    }

    //Endpoint to get paginated expenses(get page as per number of expense in a page)
    @GetMapping("/paginated")
    public Page<Expense> getAllExpensesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return expenseService.getAllExpensesPaginated(pageable);
    }

    //Endpoint to get sorted paginated expenses
    @GetMapping("/paginated-sorted")
    public Page<Expense> getAllExpensesPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "amount") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Pageable pageable = PageRequest.of(page, size, direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        return expenseService.getAllExpensesPaginated(pageable);
    }





    
}
