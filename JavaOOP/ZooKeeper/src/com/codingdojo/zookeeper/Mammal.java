package com.codingdojo.zookeeper;

public class Mammal {
	public int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public void displayEnergy() {
		System.out.println("Energy Level: " + energyLevel);
	}
}
