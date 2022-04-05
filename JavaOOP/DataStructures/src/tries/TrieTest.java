package tries;

public class TrieTest {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("card");
		trie.addWord("bumblebee");
		trie.addWord("bubble");
		trie.addWord("egg");
		trie.addWord("giraffe");
		trie.addWord("bicycle");
		trie.addWord("mouse");
		
//		System.out.println(trie.isValidPrefix("bumble"));
		trie.printAllKeys();
	}

}
