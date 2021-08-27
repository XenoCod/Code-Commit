package Graphs;

import java.util.ArrayList;

//TopoLogical sort means it there is an edge u-> v then u should always appear earlier in the graph
//It only applies to Directed Acylic Graph (DAG)

import java.util.Stack;


public class TopologicalSortDFS {
	static void addEdges(ArrayList<ArrayList<Integer>>adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
    static void topDFS(ArrayList<ArrayList<Integer>>adj, int v){
        Stack<Integer> st= new Stack<>();
        boolean visited[]= new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i])
                dfsTop(adj, i,st, visited);
        }
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }
    static void dfsTop(ArrayList<ArrayList<Integer>>adj , int s, Stack<Integer>st, boolean visited[]){
        visited[s]=true;
        for(int vertex:adj.get(s)) {
            if (!visited[vertex])
                dfsTop(adj, vertex, st, visited);

        }
        st.push(s);

    }
    

    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());

        addEdges(adj,0, 1);
        addEdges(adj,1, 3);
        addEdges(adj,2, 3);
        addEdges(adj,3, 4);
        addEdges(adj,2, 4);
        topDFS(adj,v);
    }
}

