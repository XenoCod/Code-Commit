package Graphs;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraphUsingDFS {
	//We use backtracking we check for the recursive call and make it back to default when the call is finished
	//If the node is already visited and is beeing visited again during the calll it means there is a cycle
	//We maintain 2 visited array one for the main call and other for the current vertex call
	//iF we dont find any cycle we make sure that the current node array is back to earlier state 
	//BACKTRACKING
	
	
	static void addEdges(ArrayList<ArrayList<Integer>>adj, int u, int v) {
    	adj.get(u).add(v);
    	adj.get(v).add(u);
    }
	
	static boolean isCyclic(ArrayList<ArrayList<Integer>>adj, boolean visited[], boolean visitedDfs[], int s) {
		visited[s]=true;
		visitedDfs[s]=true;
		for(int vertex: adj.get(s)) {
			if(!visited[vertex]) {
				if(isCyclic(adj, visited, visitedDfs, vertex))
					return true;
				
			}
			else if(visitedDfs[vertex])
				return true;
		}
		visitedDfs[s]=false;
		return false;
		
	}
	
	static boolean detectCycle(ArrayList<ArrayList<Integer>>adj, int v) {
		boolean visited[]= new boolean[v];
		boolean visitedDfs[]= new boolean [v];
		for(int i=0; i<v; i++) {
			if(!visited[i])
				if(isCyclic(adj, visited, visitedDfs, i))
					return true;
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		int v=9;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdges(adj, 0,1);
        addEdges(adj, 1,2);
        addEdges(adj, 1,3);
        addEdges(adj, 2,3);
        
        System.out.println(detectCycle(adj,v));
	}
}
