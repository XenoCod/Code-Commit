

package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosaRajuAlgo {
	/*
	 * Algorithm for Kosarju
	 * 
	 * Do a topological sort i.e sort the graph in terms of visiting time => Step 1
	 * Reverse the graph=> Step 2 Call dfs one by one for the element in the stack
	 * => Step 3
	 * 
	 */

	// Step 1
	void topoSort(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean visited[]) {
		
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i])
				dfs(i, adj, st, visited);

		}
	}
	
	

	void dfs(int curr_vertex, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean visited[]) {
		
		visited[curr_vertex] = true;
		for (Integer adj_vertex : adj.get(curr_vertex))
			if (!visited[adj_vertex])
				dfs(adj_vertex, adj, st, visited);

		// When backtracking insert the node into stack, typical toposort
		st.push(curr_vertex);
	}
	
	
	void reverseGraph(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> transpose,boolean visited[]) {
		
		for(int i=0; i< adj.size(); i++) transpose.add( new ArrayList<Integer>());
		
		
		for(int curr_vertex=0; curr_vertex< adj.size(); curr_vertex++) {
			visited[curr_vertex]= false;
			for(Integer adj_vertex: adj.get(curr_vertex))
				transpose.get(adj_vertex).add(curr_vertex);
				
		}
		
		
	}

	
	void printEdges(Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		while(!st.isEmpty()) {
			int curr_vertex= st.pop();
			
			if(!visited[curr_vertex])
				revDFS(curr_vertex, st, adj, visited);
		}
	}
	
	
	void revDFS(int curr_vertex, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		visited[curr_vertex]= true;
		System.out.print(curr_vertex+" ");
		for(Integer adj_vertex: adj.get(curr_vertex)) {
			if(!visited[adj_vertex]) {
				revDFS(adj_vertex, st, adj, visited);
				System.out.println();
			}
		}
	}
	
	
	void kosaraju(ArrayList<ArrayList<Integer>> adj) {

		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[adj.size()];
		
		topoSort(adj, st, visited);//Step 1
		
		ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
		reverseGraph(adj, transpose, visited); //Step 2
		
		printEdges(st, transpose, visited); // Step 3 
		

	}
	
	

	public static void main(String[] args) {

		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);

		KosaRajuAlgo obj = new KosaRajuAlgo();
		obj.kosaraju(adj);
	}

}
