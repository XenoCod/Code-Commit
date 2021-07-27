package Codes.Graphs;

import java.util.Arrays;

public class MinSpanningTreePrimsAlgo {
    static int primMST(int graph[][], int v) {
        boolean mstSet[]= new boolean[v];
        int key[]= new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0]=0;
        int res=0;
        for(int count=0;count<v;count++){
            int u=-1;
            for(int i=0;i<v;i++){
                if(!mstSet[i] && (u==-1 || key[i]<key[u]))
                    u=i;
            }

            mstSet[u]=true;
            res+=key[u];
            for(int vertex=0;vertex<v;vertex++){
                if(!mstSet[vertex] && graph[u][vertex]!=0)
                    key[vertex]=Math.min(key[vertex], graph[u][vertex]);
            }

        }
        return res;

    }
    public static void main(String[] args) {
        int graph[][]=new int[][]{{0, 5, 8, 0},{5, 0, 10, 15},{8, 10, 0, 20},{0, 15, 20, 0}};
        int v=4;
        System.out.println(primMST(graph, v));
        }
}


