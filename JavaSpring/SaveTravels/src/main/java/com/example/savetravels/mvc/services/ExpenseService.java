package com.example.savetravels.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.savetravels.mvc.models.Expense;
import com.example.savetravels.mvc.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	private final ExpenseRepo expenseRepo;
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public Expense create(Expense expense) {
		return	expenseRepo.save(expense);
	}
	
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public Expense findOneById(long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		return null;
	}
	
	public Expense update(long id, String name, String vendor, double price, String description) {
		Expense expenseToUpdate = this.findOneById(id);
		if(expenseToUpdate == null) {
			return null;
		}
		expenseToUpdate.setName(name);
		expenseToUpdate.setPrice(price);
		expenseToUpdate.setVendor(vendor);
		return expenseRepo.save(expenseToUpdate);
	}
	
	public void delete(long id) {
		expenseRepo.deleteById(id);
	}

}
