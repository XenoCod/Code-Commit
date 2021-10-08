package Trie;

class TrieNode{
	TrieNode [] children= new TrieNode[26];
	boolean isEnd;
}

class Trie{
	TrieNode root;

	public Trie(){
		root= new TrieNode();
	}

	public void insert(String word){
		TrieNode curr= root;//get the root and create curr node to perform the operation

		for(int i=0; i<word.length(); i++){
			char ch= word.charAt(i);

			if(curr.children[ch - 'a'] == null){
				curr.children[ch - 'a']= new TrieNode();//if it is empty put a new Trienode in the curr postion
			}

			curr= curr.children[ch -'a'];
		}
		curr.isEnd= true;
	}

	public boolean search(String word){
		TrieNode curr= root;

		for(int i=0; i< word.length(); i++){
			char ch= word.charAt(i);

			if(curr.children[ch - 'a'] == null)
				return false;

			curr= curr.children[ch - 'a'];
		}
		return curr.isEnd;
	}

	public boolean startsWith(String word){
		TrieNode curr= root;

		for(int i=0; i< word.length(); i++){
			char ch= word.charAt(i);

			if(curr.children[ch - 'a'] == null)
				return false;

			curr= curr.children[ch -'a'];
		}
		return true;
	}
	
	public void delete(String word) {
		TrieNode curr= root;
		
		for(int i=0; i< word.length(); i++) {
			char ch= word.charAt(i);
			
			curr=curr.children[ch -'a'];
		}
		curr.isEnd= false;
	}
}



public class Trie_Implentation {
	
	public static void main(String[] args) {
		Trie t= new Trie();

		t.insert("aditya");
		System.out.println(t.search("aditya"));
		System.out.println(t.startsWith("adi"));
		System.out.println(t.startsWith("di"));
		System.out.println(t.search("aditya"));
		t.insert("singh");
		t.delete("aditya");
		System.out.println(t.search("aditya"));
	}
}
