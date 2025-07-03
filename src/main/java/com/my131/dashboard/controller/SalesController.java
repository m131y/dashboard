package com.my131.dashboard.controller;

import com.my131.dashboard.repository.DashboardRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/sales")
public class SalesController {
    private final DashboardRepository dashboardRepository;

    public SalesController(DashboardRepository dashboardRepository) {
        this.dashboardRepository =dashboardRepository;
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "sale-add";
    }

    @PostMapping("/add")
    public String addSale(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate saleDate,
            @RequestParam int customerId,
            @RequestParam BigDecimal amount
            ) {
        System.out.println("저장");
        dashboardRepository.saveSale(saleDate, customerId, amount);

    return "redirect:/";
    }

}
