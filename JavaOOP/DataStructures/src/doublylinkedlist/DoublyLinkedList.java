package doublylinkedlist;

//!!!!!!!!
//While I didn't do the functions listed, I did what I thought would be beneficial to me learning doubly linked lists, as I had not implemented one before.
//(i did what i felt I needed to practice as well)
//!!!!!!!!

public class DoublyLinkedList {
	private Node tail;
	private Node head;
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void addToFront(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		
		newNode.next = this.head;
		newNode.prev = this.tail;
		this.head = newNode;
	}
	
	public void addToBack(int data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		
		Node currentTail = this.tail;
		
		currentTail.next = newNode;
		newNode.prev = currentTail;
		newNode.next = this.head;
		this.tail = newNode;  
		this.head.prev = this.tail;
	}
	
	public void removeFromBack() {
		if(this.head == null) {
			return;
		}
		
		if(this.head == this.tail) {
			this.head = null;
			this.tail = null;
		}
		
		Node runner = this.head;
		while(runner.next != this.tail) {
			runner = runner.next;
		}
		
		this.tail = runner;
		runner.next = this.head;
		this.head.prev = runner;
	}
	
	
	public void printValues() {
		if(this.head == null) {
			System.out.println("The list is empty!");
			return;
		}
		
		if(this.head == this.tail) {
			System.out.print(this.head.data + " -> null");
			return;
		}
		
		Node runner = this.head;
		System.out.print(runner.data + " -> ");
		while(runner != this.tail) {
			System.out.print(runner.data + " -> ");
			runner = runner.next;
		}
		
		System.out.print(this.tail.data + " -> ");
		
		System.out.print("null");
	}
	
	
	
	
	
	private class Node {
		private int data;
		private Node next;
		private Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
}
