package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SortComparator implements Comparator<GGNode> {

	@Override
	public int compare(GGNode o1, GGNode o2) {
		if (o1.getWeight() < o2.getWeight())
			return -1;
		else if (o1.getWeight() > o2.getWeight())
			return 1;
		else
			return 0;
	}
}

class GGNode {

	private int u, v, w;

	public GGNode(int _u, int _v, int _w) {
		u = _u;
		v = _v;
		w = _w;
	}

	GGNode() {
	};

	int getU() {
		return u;
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return w;
	}

}

////Union find
//class UnionFind{
//	private int [] parent, rank;
//	
//	public UnionFind(int n) {
//		parent= new int[n];
//		rank= new int [n];
//		
//		for(int i=0; i<n; i++) parent[i]= i;
//		
//	}
//	
//	public void union(int p, int q) {
//		int rootP= findParent(p);
//		int rootQ= findParent(q);
//		
//		if(rootP == rootQ) return;
//		
//		if(rank[rootP] < rank[rootQ]) parent[rootP]= rootQ;
//		else if(rank[rootP] > rank[rootQ]) parent[rootQ]= rootP;
//		else {
//			parent[rootP]= rootQ;
//			rank[rootQ]++;
//		}
//	}
//	
//	public int findParent(int GGNode) {
//		if(parent[GGNode] == GGNode)
//			return GGNode;
//		parent[GGNode]= findParent(parent[GGNode]);
//		return parent[GGNode];
//	}
//}

public class KrushKalAlgo {

	void krushkal(ArrayList<GGNode> adj, int n) {

		UnionFind uf = new UnionFind(n);
		// Sort the adj list on basis of their of Weight
		Collections.sort(adj, new SortComparator());

		int cost = 0;
		ArrayList<GGNode> mst = new ArrayList<>();

		for (GGNode adj_vertex : adj) {
			if (uf.findParent(adj_vertex.getU()) != uf.findParent(adj_vertex.getV())) {
				// If they dont belong to same component then do something
				cost += adj_vertex.getWeight();
				mst.add(adj_vertex);
				// Connect them into single component
				uf.union(adj_vertex.getU(), adj_vertex.getV());
			}
		}

		System.out.println(cost);
		for (GGNode it : mst)
			System.out.println(it.getU() + " " + it.getV());
	}

	public static void main(String[] args) {

		int n = 5;
		ArrayList<GGNode> adj = new ArrayList<GGNode>();

		adj.add(new GGNode(0, 1, 2));
		adj.add(new GGNode(0, 3, 6));
		adj.add(new GGNode(1, 3, 8));
		adj.add(new GGNode(1, 2, 3));
		adj.add(new GGNode(1, 4, 5));
		adj.add(new GGNode(2, 4, 7));
		KrushKalAlgo obj = new KrushKalAlgo();
		obj.krushkal(adj, n);
	}

}
