package Codes.Graphs;

import java.util.ArrayList;
import java.util.Stack;

import static Codes.Graphs.TopologicalSortingKahnAlgo.addEdge;

public class TopologicalSortDFS {
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

        addEdge(adj,0, 1);
        addEdge(adj,1, 3);
        addEdge(adj,2, 3);
        addEdge(adj,3, 4);
        addEdge(adj,2, 4);
        topDFS(adj,v);
    }
}

