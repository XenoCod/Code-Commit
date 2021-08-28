package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


class Pair{
	int key, weight;
	
	Pair(int _key, int _value){
		key= _key;
		weight= _value;
	}
	
	int getV() {
		return key;
	}
	
	int getWeight() {
		return weight;
	}
}


/* Nodes=> (Adjacent Node, Adjacent Node weight)
 * 0 => (1,2), (4, 1)
 * 1=> (2, 3)
 * 2=> (3,6)
 * 3=>
 * 4=>(2,2), (5,4)
 * 5=>(3,1)
 */


/*
 * Algorithm
 * 1. Topological sort the Graph
 * 2. Take out the element one by one from the stack and find out the shortest path with weights
 * 
 */
public class ShortestPathInDAG {
	
	
	
	
	private static void shortestPath(int src, ArrayList<ArrayList<Pair>> adj, int v) {
		boolean visited[]= new boolean[v];
		int distance[]= new int [v];
		Stack<Integer> st= new Stack<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		//Topological sort Algo
		for(int i=0; i<v;i++) {
			if(!visited[i]) {
				topologicalSort(adj, st, i, visited);
			}
		}
		
		distance[src]=0;
		while(!st.isEmpty()) {
//			System.out.println(st.peek());
			int node= (int ) st.pop();
			if(distance[node] != Integer.MAX_VALUE) {
				for(Pair it: adj.get(node)) {
					if(distance[node] + it.getWeight() < distance[it.getV()]) {
						distance[it.getV()]= distance[node] + it.getWeight();
					}
				}
			}
		}
		
		//Printing the result
		for(int i=0; i<v;i++) {
			if(distance[i] == Integer.MIN_VALUE) {
				System.out.println("MIN");
			}
			else {
				System.out.println("shortest distance from source to "+i+" is "+distance[i]+" ");
			}
			
		}
	}
	

	
	
	//Topo Sort
	private static void topologicalSort(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int s, boolean visited[]) {
		visited[s]=true;
		for(Pair vertex: adj.get(s)) {
			if(!visited[vertex.getV()]) {
				topologicalSort(adj, st, vertex.getV(), visited);
			}
		}
		st.push(s);
		
	}
	
	public static void main(String [] args) {
		int v=6;
		ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
		for(int i=0;i<v;i++)
			adj.add(new ArrayList<Pair>());
		
		adj.get (0).add(new Pair(1,2));
		adj.get(0).add(new  Pair(4,1));
		adj.get(1).add( new Pair(2,3));
		adj.get (4).add( new Pair(2,2));
		adj.get (2).add(new Pair(3,6));
		adj.get(4).add( new Pair(5, 4));
		adj.get(5).add( new Pair(3,1));
		
		shortestPath(0, adj, v);
	}
	
	
//	o/p
//	shortest distance from source to 0 is 0 
//	shortest distance from source to 1 is 2 
//	shortest distance from source to 2 is 3 
//	shortest distance from source to 3 is 6 
//	shortest distance from source to 4 is 1 
//	shortest distance from source to 5 is 5 

}
