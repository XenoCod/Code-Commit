package Codes.Graphs;

import java.util.Arrays;

public class DijkstraShortestPathAlgo {
    static int [] dijkstra(int graph[][], int v, int s){
        int dist[]= new int [v];
        boolean finish[]= new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        for(int count=0;count<v-1;count++){
            int u=-1;
            for(int i=0;i<v;i++)
                if(!finish[i]&&(u==-1 || dist[i]<dist[u]))
                    u=i;
            finish[u]=true;
            for(int i=0;i<v;i++)
                if(!finish[i]&& graph[u][i]!=0)
                    dist[i]=Math.min(dist[i], graph[u][i]+dist[u]);
        }
        return dist;
    }

    public static void main(String[] args) {
        int v=4;
        int graph[][] = new int[][] { { 0, 50, 100, 0},
                { 50, 0, 30, 200 },
                { 100, 30, 0, 20 },
                { 0, 200, 20, 0 },};
        int res[];
        int source=0;
        res=dijkstra(graph, v,source);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
}
