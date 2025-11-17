package com.moneymate.repository;

import com.moneymate.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findByUser_IdAndYearMonth(Long userId, String yearMonth);

    void deleteByUser_IdAndYearMonth(Long userId, String yearMonth);
}
