package com.codingdojo.zookeeper;

public class Gorilla extends Mammal {
	public Gorilla() {
		super();
	}
	
	public void throwPoo() {
		System.out.println("The gorilla threw some poo! Ewww!");
		this.energyLevel -= 5;
	}
	
	public void eatBanana() {
		System.out.println("The gorilla eats a banana.");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The gorilla begins to climb a rock. What a silly fella.");
		this.energyLevel -= 10;
	}

}
