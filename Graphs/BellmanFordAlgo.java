package Codes.Graphs;

import java.util.Arrays;

class Graph{
    class Edge{
        int src, dest, wght;
        Edge(){
            src=dest=wght=0;
        }
    }

    Edge edge[];
    int V, E;
    Graph(int v, int e){
        V=v;
        E=e;
        edge= new Edge[e];
        for(int i=0;i<e;i++)
            edge[i]= new Edge();
    }

    static void bellFord(Graph graph, int src){
        int v=graph.V;
        int e= graph.E;
        int dis[]= new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src]=0;
        for(int i=1;i<v;i++)
            for(int j=0;j<e;j++){
                int U=graph.edge[j].src;
                int V=graph.edge[j].dest;
                int W= graph.edge[j].wght;
                if(dis[U]!=Integer.MAX_VALUE && dis[U]+W<dis[V]){
                    dis[V]=dis[U]+W;
                }
            }

        for (int j = 0; j < e; ++j) {
            int U = graph.edge[j].src;
            int V = graph.edge[j].dest;
            int weight = graph.edge[j].wght;
            if (dis[U] != Integer.MAX_VALUE && dis[U] + weight < dis[V]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        printDis(dis, v);

    }

    static void printDis(int dis[], int v){
        for(int i=0;i<v;i++)
            System.out.print(dis[i]+" ");
    }
}

public class BellmanFordAlgo {
    public static void main(String[] args) {

        int V = 4;
        int E = 5;

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B) 
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].wght = 1;

        // add edge 0-2 (or A-C) 
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].wght = 4;

        // add edge 1-2 (or B-C) 
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].wght = -3;

        // add edge 1-3 (or B-D) 
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].wght = 2;

        // add edge 2-3 (or C-D) 
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].wght = 3;

        graph.bellFord(graph, 0);
    }
}
