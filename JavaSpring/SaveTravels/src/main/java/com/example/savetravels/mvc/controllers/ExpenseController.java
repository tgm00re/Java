package com.example.savetravels.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.savetravels.mvc.models.Expense;
import com.example.savetravels.mvc.services.ExpenseService;

@Controller
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenseList = expenseService.allExpenses();
		model.addAttribute("expenseList",expenseList);
		return "index.jsp";
	}
	
	@PostMapping("/expense/create")
	public String create(@ModelAttribute("expense") Expense expense, BindingResult result) {
		expenseService.create(expense);
		return "redirect:/";
	}
}
