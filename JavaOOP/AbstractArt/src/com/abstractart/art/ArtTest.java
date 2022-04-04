package com.abstractart.art;

public class ArtTest {

	public static void main(String[] args) {
		Painting myPainting = new Painting("Metallic", "Very Ugly", "Most beautiful painting on Earth");
		Sculpture mySculpture = new Sculpture("Wood");
		Museum myMuseum = new Museum();
		myMuseum.addItem(mySculpture);
		myMuseum.addItem(myPainting);
		myMuseum.display();
	}

}
