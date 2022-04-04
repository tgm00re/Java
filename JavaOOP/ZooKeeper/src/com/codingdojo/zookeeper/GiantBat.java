package com.codingdojo.zookeeper;

public class GiantBat extends Mammal {

	public GiantBat() {
		super();
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("The giant bat begins to fly.");
		this.energyLevel -= 50;
	}
	
	public void eatHuman() {
		System.out.println("The giant bat eats another human.");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("The giant bat attacks a town, resulting in the deaths of hundreds.");
		this.energyLevel -= 100;
	}
	
	

}
