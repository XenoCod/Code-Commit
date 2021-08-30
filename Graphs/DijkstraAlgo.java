package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Dijkstra is used to find the shortest path from the source to each node in UNDIRECTED Graph WITH CYCLES
 * 
 * We use Priority queue and compare the weights of each node to the current vertex if its smaller we store in distamce array
 * 
 */

class Node implements Comparator<Node>{
	private int key, weight;
	
	
	Node (){}
	Node(int k,int w){
		key=k;
		weight=w;
	}
	
	
	
	int getV() {
		return key;
	}
	
	int getWeight() {
		return weight;
	}
	
	 	@Override
	    public int compare(Node node1, Node node2) 
	    { 
	        if (node1.weight < node2.weight) 
	            return -1; 
	        if (node1.weight > node2.weight) 
	            return 1; 
	        return 0; 
	    } 
}

public class DijkstraAlgo {
	
	private static void shortestPath(int src, ArrayList<ArrayList<Node>>adj, int v) {
		int dist[]= new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src]=0;
		
		PriorityQueue<Node> pq= new PriorityQueue<Node>(v, new Node());
		pq.add(new Node(src, 0));
		
		
		 while(pq.size() > 0) {
	            Node node = pq.poll();
	            
	            for(Node it: adj.get(node.getV())) {
	                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
	                    dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
	                    pq.add(new Node(it.getV(), dist[it.getV()]));
	                }
	            }
	        }
		
		for(int i=0; i<v;i++) {
			
				System.out.println("The shortest distance from Source to "+i+" is "+ dist[i]);
			
		}
		
	}
	
	
	
	
	public static void main(String args[]) {
		ArrayList<ArrayList<Node>> adj= new ArrayList<>();
		int v=5;
		for(int i=0; i<v;i++)
			adj.add(new ArrayList<Node>());
		
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));
		
		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));
		
		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));
		
		shortestPath(0, adj, v);
		
		
	}

}
