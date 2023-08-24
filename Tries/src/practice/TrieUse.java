package practice;

public class TrieUse {

	public static void main(String[] args) {
		
		Trie t= new Trie();
		t.add("kanishk");
		t.add("abha");

		System.out.println(t.search("abha"));
//		System.out.println(t.search("abh"));
		
		t.remove("abha");
		System.out.println(t.search("abha"));
	}

}
