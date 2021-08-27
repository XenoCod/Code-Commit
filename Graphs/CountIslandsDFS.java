package Codes.Graphs;

import java.util.ArrayList;




public class CountIslandsDFS {
    //No source provided and the graphs may be disconected
    static int countIsland(ArrayList<ArrayList<Integer>>adj, int v){
        boolean visited[]= new boolean[v];
        int count=0;
        for(int i=0;i<v;i++)
            if(!visited[i]) {
                countDFS(adj, i, visited);
                count++;
            }
        return count;
    }
    static void countDFS(ArrayList<ArrayList<Integer>>adj, int s, boolean visited[]){
        visited[s]=true;
        for(int vertex:adj.get(s)){
            if(!visited[vertex]){
                visited[vertex]=true;
                countDFS(adj, vertex, visited);
            }

        }
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
        System.out.println(countIsland(adj,v));
    }
}
