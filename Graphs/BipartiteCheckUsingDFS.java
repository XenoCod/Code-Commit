package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteCheckUsingDFS {
	 static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
	    	adj.get(u).add(v);
	    	adj.get(v).add(u);
	    }
	 
	 static boolean isBipartite(ArrayList<ArrayList<Integer>>adj, int s, int color[]) {

		 for(int vertex: adj.get(s)) {
			 if(color[vertex] == -1) {
				 color[vertex]= 1- color[s];
				 if(!isBipartite(adj, vertex, color))
					 return false;
				 
			 }
			 else if(color[vertex]== color[s])
				 return false;
		 }
		 return true;
	 }
	 
	 static boolean checkBipartie(ArrayList<ArrayList<Integer>>adj, int v) {
		 int color[]= new int [v];
		 Arrays.fill(color,-1);
		 for(int i=0; i<v;i++) {
			 if(color[i]== -1) {
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
        addEdges(adj, 1, 2);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 7);
        addEdges(adj, 3, 4);
        addEdges(adj, 4, 5);
        addEdges(adj, 5	, 8);
        addEdges(adj, 7, 6);
        addEdges(adj, 6, 5);
        
        
        
        
//        addEdges(adj,1, 2);
//     addEdges(adj,2, 3);
//      addEdges(adj, 2, 8);
//      addEdges(adj,3, 4);
//      addEdges(adj,8, 5);
//      addEdges(adj,4, 5);
//      addEdges(adj,5, 6);
//      addEdges(adj,6, 7);
//      
        System.out.println(checkBipartie(adj,v)== false? "Not Bipartite": "Bipartite");
	}

}
