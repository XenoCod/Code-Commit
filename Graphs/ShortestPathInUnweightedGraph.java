package Codes.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Codes.Graphs.BFS.addEdges;

public class ShortestPathInUnweightedGraph {
    static void findShortestPath(ArrayList<ArrayList<Integer>>adj, int v, int s){
        boolean visited[]= new boolean[v];
        Queue<Integer>q= new LinkedList<>();
        q.add(s);
        visited[s]=true;
        int dist[]= new int [v];

        while(!q.isEmpty()){
            int u=q.poll();
            for(int vertex:adj.get(u))
                if(!visited[vertex]){
                    dist[vertex]=dist[u]+1;
                    q.add(vertex);
                    visited[vertex]=true;
                }
        }

        for(int i=0;i<dist.length;i++)
            System.out.print(dist[i]+" ");
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdges(adj, 0, 1);
        addEdges(adj, 0,2);
        addEdges(adj,1,2);
        addEdges(adj,1,3);
        addEdges(adj,2,3);
        findShortestPath(adj,v, 0);

    }


}
