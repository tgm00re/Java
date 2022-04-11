package com.example.savetravels.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String create( @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		} else {
			System.out.println("Request was valid.");
			expenseService.create(expense);
			return "redirect:/";
		}
	}

	@RequestMapping("/expense/view/{id}")
	public String edit(Model model, @PathVariable("id") long id) {
		Expense expense = expenseService.findOneById(id);
			model.addAttribute("expense", expense);
			return "displayone.jsp";
	}

	@RequestMapping("/expense/edit/{id}")
	public String edit(@ModelAttribute("expense") Expense expense, Model model, @PathVariable("id") long id) {
		Expense expenseToUpdate = expenseService.findOneById(id);
		if(expense == null) {
			return "redirect:/";
		} else {
			model.addAttribute("expense", expenseToUpdate);
			return "update.jsp";
		}
	}

	@PostMapping("/expense/edit/process/{id}")
	public String processEdit(@ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") long id) {
		if(result.hasErrors()) {
			System.out.println("Hello!");
			return "/expense/edit/" + Long.toString(id);
		} else {
			expenseService.update(id, expense.getName(), expense.getVendor(), expense.getPrice(), expense.getDescription());
			return "redirect:/";
		}
	}

	@RequestMapping("/expense/delete/{id}")
	public String deleteExpense(@PathVariable("id") long id) {
		expenseService.delete(id);
		return "redirect:/";
	}


}
