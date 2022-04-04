package com.abstractart.art;

public class Painting extends Art {
	String paintType;
	
	public Painting(String paintType, String description, String title) {
		this.title = title;
		this.description = description;
		this.paintType = paintType;
	}
	
	@Override
	void viewArt() {
		System.out.println("Title: " + title);
		System.out.println("You are a viewing " + this.paintType + " painting.");
		System.out.println("Description: " + this.description);

	}

}
