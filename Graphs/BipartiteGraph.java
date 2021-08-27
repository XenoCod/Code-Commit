package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//A bipartite graph is graph which can be colored with 2 colors such that no two adjacent node have the same colors

//If a graph has a odd length cycle it cannot be a bipartite graph and its not necesarry to have a even length cycle to be bipartite
//IF we able to color the whole graph then its a bipartite graph else not
//BFS Traversal

public class BipartiteGraph {
	
	
	  static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
	    	adj.get(u).add(v);
	    	adj.get(v).add(u);
	    }
	  
	  
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v, int color[]){
    	Queue<Integer> q= new LinkedList<>();
    	q.add(v);
    	color[v]=1;
    	while(!q.isEmpty()) {
    		int u= q.poll();
    		for(int vertex:adj.get(u)) {
    			if(color[vertex] == -1) {
    				q.add(vertex);
    				color[vertex]=1-color[u];
    			}
    			else if(color[vertex] ==  color[u])
    				
    				return false;
    		}
    	}
    	return true;
    	
    }
    
    static boolean checkBipartie(ArrayList<ArrayList<Integer>> adj, int v) {
    		int color[]= new int [v];
    		Arrays.fill(color,-1);
    		for(int i=0; i<v;i++) {
    			if(color[i]==-1) {
    				if(!isBipartite(adj, i, color))
    					return false;
    				
    			}
    		}
    		return true;
    }
    
  
    public static void main(String[] args) {
    	int v=9 ;
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        
        //Not bipartite example
        /*
         * 
         
//        addEdges(adj,1, 2);
//        addEdges(adj,2, 3);
//        addEdges(adj, 2, 8);
//        addEdges(adj,3, 4);
//        addEdges(adj,8, 5);
//        addEdges(adj,4, 5);
//        addEdges(adj,5, 6);
//        addEdges(adj,6, 7);
 */
        
        
        //Bipartite example
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 7);
        addEdges(adj, 3, 4);
        addEdges(adj, 4, 5);
        addEdges(adj, 5	, 8);
        addEdges(adj, 7, 6);
        addEdges(adj, 6, 5);
        System.out.println(checkBipartie(adj,v)== false? "Not Bipartite": "Bipartite");

    }
}
