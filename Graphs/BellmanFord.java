package Graphs;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

	/*
	 * Algo for Bellman ford algo
	 * 
	 * Conditions= There should be no negetive cycle and the graph should be
	 * direceted graph
	 * 
	 * We relax all the edges N-1 times If after relaxing node for N-1 times int the
	 * nth iteration we check whether the graph contains negetive cycle if it does
	 * we print -1 else we print the distance array
	 * 
	 * 
	 */

	void bellmanFord(ArrayList<GGNode> adj) {
		int n = adj.size();
		int distance[] = new int[n];
		Arrays.fill(distance, 10000000);

		distance[0] = 0; // source to source distance is 0

		for (int i = 1; i <= n - 1; i++) {
			for (GGNode curr_vertex : adj) {
				if (curr_vertex.getWeight() + distance[curr_vertex.getU()] < distance[curr_vertex.getV()])
					distance[curr_vertex.getV()] = curr_vertex.getWeight() + distance[curr_vertex.getU()];
				// If the distance from current vertx with weight is less than distance stored
				// then replace it
			}
		}

		// Checking for negetive cycle
		boolean negetive_cycle = false;
		for (GGNode curr_vertex : adj) {
			if (curr_vertex.getWeight() + distance[curr_vertex.getU()] < distance[curr_vertex.getV()]) {
				negetive_cycle = true;
				break;
			}
		}
		
		
		if(negetive_cycle) System.out.println("Negetive cycle detected");
		
		else Arrays.stream(distance).forEach(i-> System.out.print(i+ " "));
	}

	public static void main(String[] args) {
		int n = 6;
		ArrayList<GGNode> adj = new ArrayList<GGNode>();

		adj.add(new GGNode(3, 2, 6));
		adj.add(new GGNode(5, 3, 1));
		adj.add(new GGNode(0, 1, 5));
		adj.add(new GGNode(1, 5, -3));
		adj.add(new GGNode(1, 2, -2));
		adj.add(new GGNode(3, 4, -2));
		adj.add(new GGNode(2, 4, 3));

		BellmanFord obj = new BellmanFord();
		obj.bellmanFord(adj);

	}

}
