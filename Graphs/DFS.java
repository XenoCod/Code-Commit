package Graphs;

import java.util.ArrayList;

import static Codes.Graphs.BFS.addEdges;

public class DFS {
    static  void  dfsRec(ArrayList<ArrayList<Integer>>adj, int s, boolean[]visited){
        visited[s]=true;
        System.out.print(s+" ");
        for(int vertex:adj.get(s))
            if(!visited[vertex]) {
                visited[vertex] = true;
                dfsRec(adj, vertex, visited);
            }
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int s, int v){
        boolean []visited= new boolean[v];
        dfsRec(adj, 0,visited);

    }
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    	adj.get(u).add(v);
    	adj.get(v).add(u);
    }
    
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdges(adj, 0,1);
        addEdges(adj, 0,2);
        addEdges(adj, 1, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 4);
        addEdges(adj, 3, 4);
        //Traversal with the source
        dfs(adj,0, v);

    }
    


}
