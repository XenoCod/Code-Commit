package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.*;

//Leetcode imp=  721 

class UnionFind{
    private int[] parent, rank;
    
    public UnionFind(int n){
        parent= new int[n];
        rank= new int[n];
         // array is initialized with the total size of accounts and each is given a unique id. When the index of an array is equal to the value inside it, it means it is its own parent.
// if it is different, it means that it has some other parent.  Basically we are mapping each account to its index. And at the start, every account is its own parent.
        for(int i=0; i<n; i++)
            parent[i]= i;
    
    }
    // This method find's the parent of a particular index. 
    public int findParent(int node){
        if(parent[node] == node)
            return node;
        
       
        parent[node]= findParent(parent[node]);
        return parent[node];
    }
                       // If they weren't already connected, then connect them. For connecting them, we would reassign the index of the account of where we found our email to the current account we are processing.

    public void union(int p, int q){
        int rootP= findParent(p);
        int rootQ= findParent(q);
        
        if(rootP == rootQ) return;
        
        if(rank[rootP] < rank[rootQ]) parent[rootP]= rootQ;
        else if(rank[rootP] > rank[rootQ]) parent[rootQ]= rootP;
        else{
            parent[rootP]= rootQ;
            rank[rootQ]++;
        }
    }
    
    
}

public class AccountMerge {
	static void accountMerge(List<List<String>> accounts) {
		 int n= accounts.size();
	        UnionFind uf= new UnionFind(n);
	        // This hashmap contains the email to index mapping. We will use this map to find the particular account when an email has already been found.
	        Map<String, Integer> emailMap= new HashMap<>();
	        // Traverse each List<String> from the first index i.e. skip first index which is the name and just traverse on the emails
	        for(int i=0; i<n;i++){
	            for(int j=1; j< accounts.get(i).size(); j++){
	                String email= accounts.get(i).get(j);
	                // The email in this account has already been registered before.
	                if(emailMap.containsKey(email)){
	                    // Find that account's index
	                    int person= emailMap.get(email);
	                    // Find the parent of that current account
	                    int p1= uf.findParent(i);
	                    // Find the parent of the account where our email in the map had been found
	                    int p2= uf.findParent(person);
	                    // If they weren't already connected, then connect them. For connecting them, we would reassign the index of the account of where we found our email to the current account we are processing.
	                    uf.union(p1,p2);
	                }
	                
	                else emailMap.put(email, i);// Otherwise just track it
	            }
	        }
	        
	        
	        /* Now that we have our parents array ready where each index is either it's own parent of has some other account's index, 
	we need to merge all accounts who's parents are the same into one account. 
	The users map will contain index to TreeSet of email mapping. 
	Note that treeset sorts the elements inside it in natural order, therefore no need to worry about sorting when using this data structure. 
	For adding an element, it takes O(logn) operation. For n emails, it would take O(nlogn) and O(n) space.
	*/
	        Map<Integer, TreeSet<String>> users= new HashMap<>();
	        for(int i=0; i< accounts.size(); i++){
	            // find the parent. If an element in the parent's array doesn't equal it's index, It's parent is different. Retrieve that id.
	            int parent= uf.findParent(i);
	            // get all email's particular to the index right now. Note that this is not collecting the parent's email at al..
	            List<String> userEmails= accounts.get(i);
	            // create the treeset if not already there for that parent
	            users.putIfAbsent(parent, new TreeSet<String> ());
	            // get the treeset from the parent, and add all the email excluding the emails in them.
	            users.get(parent).addAll(userEmails.subList(1, userEmails.size()));
	            
	        }
	        // We not have a map with index and a treemap containing all the emails. Now we are Building final result. 
	        List<List<String>> res= new ArrayList<>();
	        for(Integer userID: users.keySet()){
	            // idx is the account id, get that particular account's name. We need to append it to our arraylist before returning it.
	            String userName= accounts.get(userID).get(0);
	            
	            ArrayList<String> list= new ArrayList<>(users.get(userID));
	            list.add(0, userName);
	            res.add(list);
	        }

	        //Printing the result
	        for(List<String> result:res) System.out.println(result);
	}
	public static void main(String[] args) {
		List<List<String>> accounts= new ArrayList<>();
//		accounts.add(new ArrayList<>()))
		 String acc[][] = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
				{ "John", "johnsmith@mail.com", "john00@mail.com" }, { "Mary", "mary@mail.com" },
				{ "John", "johnnybravo@mail.com" } };
		 
		 
		 for(String [] list: acc) {
			 accounts.add(Arrays.asList(list));
		 }
		accountMerge(accounts);

	}
}
