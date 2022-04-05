package tries;

import java.util.HashMap;

public class Trie {

	private Node root;
	public Trie() {
		this.root = new Node();
	}
	
	public void addWord(String word) {
		Node currentNode = this.root;
		char[] charArr = word.toCharArray();
		for(char letter : charArr) {
			if(!currentNode.map.containsKey(letter)) {
				//Create a new node 
				Node newNode = new Node();
				currentNode.map.put(letter, newNode);	
			}
			currentNode = currentNode.map.get(letter);
		}
		//At this point, we are at the end of the word, so we set currentNode's iscompleteword to true!

		currentNode.isCompleteWord = true;
	}
	
	
	public boolean isValidPrefix(String prefix) {
		Node currentNode = this.root;
		char[] charArr = prefix.toCharArray();
		for(char letter : charArr) {
			
			if(!currentNode.map.containsKey(letter)) {
				return false;
			}
			currentNode = currentNode.map.get(letter);
		}
		return true;
	}
	
	
	public boolean isWordValid(String word) {
		Node currentNode = this.root;
		char[] charArr = word.toCharArray();
		for(char letter : charArr) {
			System.out.println(letter);
			if(!currentNode.map.containsKey(letter)) {
				return false;
			}
			currentNode = currentNode.map.get(letter);
		}
		if(currentNode.isCompleteWord) {
			return true;
		}
		return false;
	}
	
	public void printAllKeys() {
		printAllKeysHelper(this.root);
	}
	
	private void printAllKeysHelper(Node currentNode) {
		
		for(char key : currentNode.map.keySet()) {
			System.out.print(" " + key );
			printAllKeysHelper(currentNode.map.get(key));
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	private class Node{
		private HashMap<Character,Node> map;
		private boolean isCompleteWord;
		
		public Node() {
			this.map = new HashMap<Character,Node>();
			this.isCompleteWord = false;
		}
	}
	
}
