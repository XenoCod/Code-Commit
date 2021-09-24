package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class GNode implements Comparator<GNode>{
	private int w, v;
	GNode(int _v, int _w){
		w=_w;
		v=_v;
	}
	GNode() {}
	
	int getV() {
		return v;
	}
	
	int getWeight() {
		return w;
	}
	
	public int compare(GNode n1, GNode n2) {
		if(n1.getWeight() < n2.getWeight()) return -1;
		else if(n1.getWeight() > n2.getWeight()) return 1;
		else return 0;
	}
}

public class PrimsAlgo {
	//TC= O(N logN)
	//SC= O(N)
	void primsAlgo(ArrayList<ArrayList<Node>> adj, int n) {
		int weights[]= new int[n];//storing the weights of each nodes
		boolean visited[]= new boolean[n];
		int parents[]= new int[n];//we will store the parents for each min edge
		
		Arrays.fill(weights, Integer.MAX_VALUE);
		
		weights[0]=0;
		PriorityQueue <Node> pq= new PriorityQueue<Node>(n, new Node());
		
		pq.add(new Node(0, weights[0]));
		
		for(int i=0; i<n-1; i++) {
			Node curr= pq.poll();
			
//			int curr_weight=curr.getWeight();
			int curr_vertex= curr.getV();
			
			//mark the node as visited
			visited[curr_vertex]= true;
			
			//Traverse for all its adjacent nodes
			for(Node adj_vertex: adj.get(curr_vertex)) {
				if(!visited[adj_vertex.getV()] && adj_vertex.getWeight() < weights[adj_vertex.getV()]) {
					//If the adjacent node is not visited and the weight is smaller than weights stored in the weights array then change
					parents[adj_vertex.getV()]= curr_vertex;
							
					weights[adj_vertex.getV()]= adj_vertex.getWeight();
					visited[adj_vertex.getV()] =true;
					pq.add(new Node(adj_vertex.getV(), weights[adj_vertex.getV()]));
				}
				
				
			}
			
			
			
		}
		
		for(int i=1; i<n; i++) System.out.print(parents[i]+" ");
		
		
			
		
	}

	public static void main(String[] args) {
		int n = 5;
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());

		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));

		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));

		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));

		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));

		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));

		PrimsAlgo obj = new PrimsAlgo();
		obj.primsAlgo(adj, n);

	}

}
