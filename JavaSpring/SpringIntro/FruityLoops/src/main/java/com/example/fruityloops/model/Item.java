package com.example.fruityloops.model;

public class Item {
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Item() {
		this("Unknown Item", 0.00);
	}
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
}
