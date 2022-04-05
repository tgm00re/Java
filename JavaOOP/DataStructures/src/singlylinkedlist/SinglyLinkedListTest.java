package singlylinkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		
		singlyLinkedList.addToFront(5);
		singlyLinkedList.addToFront(10);
		singlyLinkedList.addToFront(32);
		singlyLinkedList.addToBack(12);
		singlyLinkedList.addToFront(100);
		singlyLinkedList.addToFront(91);
		singlyLinkedList.printValues();

	}

}
