package Codes.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static void addEdges(ArrayList<ArrayList<Integer>>adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);

    }


    static void bfs(ArrayList<ArrayList<Integer>>adj, int v, int s){
        boolean visited[]= new boolean[v+1];
        Queue<Integer> q= new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int u= q.poll();
            System.out.print(u+" ");
            for(int vertex:adj.get(u)){
                if(!visited[vertex]){
                    q.add(vertex);
                    visited[vertex]=true;
                }
            }

        }
    }


    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++) {
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(adj.get(i).get(j) + " ");
            System.out.println();
        }
    }


    //BFS when no source is passed and graph may be disconnected
    static void bfsDis(ArrayList<ArrayList<Integer>>adj, int v){
        boolean visited[]= new boolean[v+1];
        for(int i=0;i<v;i++)
            if(!visited[i])
                bfsdis(adj, i, visited);
    }
    static void bfsdis(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]){
        Queue <Integer> q= new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while (!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int vertex:adj.get(u)){
                if(!visited[vertex]){
                    q.add(vertex);
                    visited[vertex]=true;
                }
            }

        }
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
//        printGraph(adj);
//        bfs(adj, v, 0);// bfs when the source is passed

        //bfs when no source is passed and graph may be disconnected
        bfsDis(adj,v);

    }
}
