package com.moneymate.service;

import com.moneymate.entity.Budget;
import com.moneymate.entity.User;
import com.moneymate.repository.BudgetRepository;
import com.moneymate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetService(BudgetRepository budgetRepository,
                         UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    // 저장
    public Budget saveBudget(Long userId, Budget budget) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        budget.setUser(user);
        return budgetRepository.save(budget);
    }

    // 조회
    public List<Budget> getBudgetForMonth(Long userId, String yearMonth) {
        return budgetRepository.findByUser_IdAndYearMonth(userId, yearMonth);
    }

    // 삭제
    public void deleteBudget(Long userId, String yearMonth) {
        budgetRepository.deleteByUser_IdAndYearMonth(userId, yearMonth);
    }
}
