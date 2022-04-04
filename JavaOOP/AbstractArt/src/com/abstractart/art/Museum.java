package com.abstractart.art;
import java.util.ArrayList;
public class Museum {
	public ArrayList<Art> meseum;
	
	public Museum() {
		this.meseum = new ArrayList<Art>();
	}
	
	public void addItem(Art artPiece) {
		this.meseum.add(artPiece);
	}
	
	public void display() {
		for(int i = 0; i < this.meseum.size(); i++) {
			System.out.println("================");
			this.meseum.get(i).viewArt();
			System.out.println("================");
		}
	}

}
