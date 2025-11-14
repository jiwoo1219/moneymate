package com.moneymate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moneymate.entity.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    // 특정 사용자 예산 전체
    List<Budget> findByUserId(Long userId);

    // 사용자 + 카테고리로 1건 (있으면)
    Optional<Budget> findByUserIdAndCategory(Long userId, String category);
}

