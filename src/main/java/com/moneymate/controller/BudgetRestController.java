package com.moneymate.controller;

import com.moneymate.entity.Budget;
import com.moneymate.service.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetRestController {

    private final BudgetService budgetService;

    public BudgetRestController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    // === 예산 저장 ===
    @PostMapping("/{userId}")
    public Budget saveBudget(
            @PathVariable Long userId,
            @RequestBody Budget budget) {

        return budgetService.saveBudget(userId, budget);
    }

    // === 예산 조회 ===
    @GetMapping("/{userId}/{yearMonth}")
    public List<Budget> getBudgets(
            @PathVariable Long userId,
            @PathVariable String yearMonth) {

        return budgetService.getBudgetForMonth(userId, yearMonth);
    }

    // === 예산 삭제 ===
    @DeleteMapping("/{userId}/{yearMonth}")
    public void deleteBudget(
            @PathVariable Long userId,
            @PathVariable String yearMonth) {

        budgetService.deleteBudget(userId, yearMonth);
    }
}
