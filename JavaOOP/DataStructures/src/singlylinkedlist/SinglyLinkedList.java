package singlylinkedlist;

public class SinglyLinkedList {
	
	private Node head;
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void addToFront(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			return;
		}
		
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public void addToBack(int data){
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			return;
		}
		
		Node runner = this.head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = newNode;
		
	}
	
	public void removeFromFront() {
		if(this.head == null) {
			return;
		}
		this.head = this.head.next;
	}
	
	
	public void removeFromBack() {
		if(this.head == null) {
			return;
		}
		
		Node runner = this.head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = null;
	}
	
	
	public void printValues() {
		if(this.head == null) {
			System.out.println("The list is empty!");
			return;
		}
		
		Node runner = this.head;
		while(runner != null) {
			System.out.print(runner.data + " -> ");
			runner = runner.next;
		}
		System.out.print("null");
	}
	
	
	
	
	

	
	
	private class Node{
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}

