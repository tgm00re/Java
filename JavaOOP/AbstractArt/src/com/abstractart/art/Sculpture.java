package com.abstractart.art;

public class Sculpture extends Art {
	
	String material;
	
	public Sculpture(String material) {
		this.material = material;
	}

	@Override
	void viewArt() {
		System.out.println("You are viewing a sculpture made of " + material);
	}

}
