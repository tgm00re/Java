package com.example.savetravels.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.savetravels.mvc.models.Expense;
import com.example.savetravels.mvc.services.ExpenseService;

@RestController
public class ExpenseApi {
	
	private final ExpenseService expenseService;
	public ExpenseApi(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping(value="/api/expenses/create", method=RequestMethod.POST)
	protected Expense createExpense(
			@RequestParam(value="name") String name,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="price") double price,
			@RequestParam(value="description") String description
			) {
		Expense expense = new Expense(name, vendor, price, description);
		return expenseService.create(expense);
	}
	
	@RequestMapping(value="/api/expenses")
	protected List<Expense> allExpenses(){
		return expenseService.allExpenses();
	}
	
	@RequestMapping(value="/api/expenses/{id}")
	protected Expense findOne(@PathVariable("id") long id) {
		return expenseService.findOneById(id);
	}
	
	@RequestMapping(value="/api/expenses/delete/{id}")
	protected void destroy(@PathVariable("id") long id) {
		expenseService.delete(id);
	}
	
	@RequestMapping(value="/api/expenses/edit/{id}", method=RequestMethod.PUT)
	protected Expense updateExpense(
			@PathVariable("id") long id,
			@RequestParam(value="name") String name,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="price") double price,
			@RequestParam(value="description") String description
			) {
		return expenseService.update(id, name, vendor, price, description);
	}
	
	
}
