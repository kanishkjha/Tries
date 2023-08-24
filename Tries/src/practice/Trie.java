package practice;

class TrieNode{
	
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data){
		this.data=data;
		isTerminating=false;
		children= new TrieNode[26];
		childCount=0;
	}
}

public class Trie {

	private TrieNode root;
	
	public Trie() {
		root= new TrieNode('\0');
	}
	
// Searching a word from the dictionary
	
	public boolean search(String word) {
		
		return search(root, word);
	}
	
	private boolean search(TrieNode root, String word) {
		
		if(word.length()==0) {
			return root.isTerminating;
		}
		
		int childIndex=word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		
		if(child==null) {
			return false;
		}
		
		return search(child, word.substring(1));
	}

// Adding a word into the dictionary
	
	private void add(TrieNode root, String word) {
		
		if(word.length()==0) {
			root.isTerminating=true;
			return;
		}
		
		int childIndex=word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		
		if(child==null) {
			child= new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		
		add(child,word.substring(1));
	}
	
	public void add(String word) {
		
		add(root, word);
	}
	
// removing a word
	
	public void remove(String word) {
		
		remove(root,word);
	}

	private void remove(TrieNode root, String word) {
		
		if(word.length()==0) {
			root.isTerminating=false;
			return;
		}
		
		int childIndex=word.charAt(0)-'a';
		TrieNode child= root.children[childIndex];
		
		if(child==null) {
			return;
		}
		
		remove(child, word.substring(1));
		
// We can only remove child if it is non-terminating and its number of children are zero.
		if(!child.isTerminating && child.childCount==0) {
			
// Now, we can afford to delete child.
				root.children[childIndex]=null;
				child=null;
				root.childCount--;
		}
	}
}
