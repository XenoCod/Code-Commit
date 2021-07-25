package Codes.Graphs;

import java.util.ArrayList;

import static Codes.Graphs.BFS.addEdges;

public class DetectCycleInUndirectedGraph {

    static boolean findCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent){
        visited[s]=true;
        for(int vertex:adj.get(s)){
            if(!visited[vertex]) {
                if (findCycle(adj, vertex, visited, s))
                    return true;
            }
                else if(vertex!=parent)
                    return true;

        }
        return false;
    }
    static boolean detectCycle(ArrayList<ArrayList<Integer>>adj, int v){
        boolean visited[]= new boolean[v];
        for(int i=0;i<v;i++)
            if(!visited[i])
                if(findCycle(adj, i, visited, -1))
                    return true;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdges(adj, 0,1);
        addEdges(adj, 1,2);
        addEdges(adj, 1,3);
        addEdges(adj, 2,3);
        System.out.println(detectCycle(adj, v));
    }
}
