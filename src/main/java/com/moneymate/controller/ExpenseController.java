package com.moneymate.controller;

import com.moneymate.entity.Expense;
import com.moneymate.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    // === Lombok 없이 생성자 직접 작성 ===
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // 지출 추가
    @PostMapping("/add")
    public Expense addExpense(
            @RequestParam Long userId,
            @RequestBody Expense expense
    ) {
        return expenseService.saveExpense(userId, expense);
    }

    @GetMapping("/expense")
    public String expensePage() {
        return "expense";  // templates/expense.html
    }

    // 특정 달 전체 지출 조회
    @GetMapping("/month")
    public List<Expense> getByMonth(
            @RequestParam Long userId,
            @RequestParam int year,
            @RequestParam int month
    ) {
        return expenseService.getMonthExpenses(userId, year, month);
    }

    // 삭제
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
