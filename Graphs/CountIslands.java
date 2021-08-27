package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Codes.Graphs.AdjanceyList.addEdge;

public class CountIslands {
    static void bfsDis(ArrayList<ArrayList<Integer>>adj, int s, boolean visited[]){
        Queue<Integer> q= new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while (!q.isEmpty()){
            int u=q.poll();
            for(int vertex:adj.get(u))
                if(!visited[vertex]){
                    visited[vertex]=true;
                    q.add(vertex);
                }

        }
    }
    static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);

    }

    static int countIslands(ArrayList<ArrayList<Integer>>adj, int v){
        boolean visited[]= new boolean[v+1];
        int count=0;
        for(int i=0;i<v;i++)
            if (!visited[i]){
                bfsDis(adj,i, visited);
                count++;
            }
        return count;

    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);
        System.out.println("Total islands=> "+countIslands(adj, v));
    }
}
