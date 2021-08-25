public class DetectCycleInUndirectedGraphUsingDFS{
    static boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj, int v){}
    public static void main(String [] args){
        int v=4;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        addEdges(adj, 0,1);
        addEdges(adj, 1,2);
        addEdges(adj, 1,3);
        addEdges(adj, 2,3);
        System.out.println(detectCycleDFS(adj, v));
    }
}