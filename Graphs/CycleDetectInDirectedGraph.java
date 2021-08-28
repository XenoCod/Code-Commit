package Graphs;

import java.util.ArrayList;

//We use Kahn algo of Topological sort as we know that topological sort is only possible
//for Acylic DAG so we use a counter if the counter !=  vertex in the graph then it have a
//cycle

import java.util.LinkedList;
import java.util.Queue;

//import static Graphs.TopologicalSortingKahnAlgo.addEdge;

public class CycleDetectInDirectedGraph {
	
	
    static boolean detectCyle(ArrayList<ArrayList<Integer>>adj, int v){
        int inDegree[]= new int[v];
        //fill the indegree 
        for(int i=0;i<v;i++)
            for(int vertex:adj.get(i))
                inDegree[vertex]++;
        //Add the vertex which has indegree ==0
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<v;i++)
            for(int vertex:adj.get(i))
                if(inDegree[vertex]==0)
                    q.add(vertex);

        
        //Start traversing one after another
                int count=0;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int vertex:adj.get(u)){
                inDegree[vertex]--;
                if(inDegree[vertex]==0)
                    q.add(vertex);
            }
            count++;
        }
        return (count!=v);
    }
    
    
    static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v) {
    	adj.get(u).add(v);
    	adj.get(v).add(u);
    }
    
    
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);
        System.out.println(detectCyle(adj,v));
    }
}
