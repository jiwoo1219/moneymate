package com.moneymate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moneymate.entity.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // 자주 쓰는 조회 패턴 (선택)
    List<Expense> findByUserId(Long userId);

    List<Expense> findByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end);

    List<Expense> findByUserIdAndCategory(Long userId, String category);
}

