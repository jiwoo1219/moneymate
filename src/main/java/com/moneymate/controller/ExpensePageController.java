package com.moneymate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpensePageController {

    @GetMapping("/expense")
    public String expensePage() {
        return "expense";  // templates/expense.html 실행
    }
}
