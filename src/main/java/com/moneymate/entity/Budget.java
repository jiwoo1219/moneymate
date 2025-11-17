package com.moneymate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budgetId;

    @Column(nullable = false)
    private String yearMonth;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getter / Setter
    public Long getBudgetId() { return budgetId; }
    public void setBudgetId(Long budgetId) { this.budgetId = budgetId; }

    public String getYearMonth() { return yearMonth; }
    public void setYearMonth(String yearMonth) { this.yearMonth = yearMonth; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
