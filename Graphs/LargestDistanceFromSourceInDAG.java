package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair{
	int key, weight;
	Pair(int _key, int _weight){
		key=_key;
		weight= _weight;
	}
	
	int getV() {
		return key;
	}
	
	int getWeight() {
		return weight;
	}
}

public class LargestDistanceFromSourceInDAG {
	
	private static  void largestPath(int src, ArrayList<ArrayList<Pair>> adj, int v) {
		int dist[]= new int [v];
		boolean visited[]= new boolean[v];
		Stack<Integer> st= new Stack<>();
		
		Arrays.fill(dist, Integer.MIN_VALUE);
		
		for(int i=0; i<v;i++) {
			if(!visited[i]) {
				topSort(adj, i, visited, st);
			}
		}
		
		dist[src]=0;
		while(!st.isEmpty()) {
			int node=(int) st.pop();
			for(Pair it: adj.get(node)) {
				if(dist[node] != Integer.MIN_VALUE) {
					if(dist[node] + it.getWeight() > dist[it.getV()]) {
						dist[it.getV()]= dist[node] + it.getWeight();
					}
				}
			}
			
		}
		
		for(int i=0; i<v;i++) {
			if(dist[i] == Integer.MIN_VALUE) {
				System.out.println("Cant be reached");
			}
			else {
				System.out.println("The farthest distance from source to "+i+" is "+ dist[i]);
			}
		}
		
	}
	
	private static void topSort(ArrayList<ArrayList<Pair>>adj, int s, boolean visited[], Stack <Integer> st) {
		visited[s]=true;
		for(Pair it: adj.get(s)) {
			if(!visited[it.getV()]) {
				topSort(adj, it.getV(), visited, st);
			}
		}
		st.push(s);
		
	}
	
	public static void main(String[] args) {
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
		
		largestPath(0, adj, v);
	}
}
