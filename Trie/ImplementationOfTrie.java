package Codes.Trie;

import com.sun.jdi.ThreadReference;

class TrieNode{
    TrieNode []child= new TrieNode[26];
    boolean isEnd;
    TrieNode(){
        isEnd=false;
        for(int i=0;i<26;i++)
            child[i]=null;
    }
    static TrieNode root;
    static void insert(String key){
        TrieNode curr= root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null)
                curr.child[index]=new TrieNode();
            curr=curr.child[index];
        }
        curr.isEnd=true;
    }

    static boolean search(String key){
        TrieNode curr= root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(curr.child[index]==null)
                return false;
            curr=curr.child[index];
        }
        return curr.isEnd && curr!=null;
    }


}

public class ImplementationOfTrie {
    public static void main(String[] args) {
        TrieNode t= new TrieNode();
        t.root=new TrieNode();
        TrieNode.insert("bad");
        TrieNode.insert("bat");
        TrieNode.insert("geek");
        TrieNode.insert("adi");
        TrieNode.insert("aditya");
        System.out.println(TrieNode.search("adi"));
        System.out.println(TrieNode.search("ba"));

    }
}
