package Graphs;
//Leetcode 547: Number of Provinces


class UnionFind{
    private int count;
    private int [] parent, rank;
    
    //Initliaze
    public UnionFind(int n){
        count=n;
        parent= new int [n];
        rank= new int[n];
        
        //Making set
        for(int i=0; i<n;i++){
            parent[i]= i;
            rank[i]=1;
        }
    }
    
    //find parent
    public int findParent(int node){
        //Path compresssion
        if(node == parent[node])
            return node;
        parent[node]= findParent(parent[node]); 
        return parent[node];
    }
    
    //Uniom
    public void union(int p, int q){
        int rootP= findParent(p);
        int rootQ= findParent(q);
        if (rootP == rootQ) return;
        if(rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else if(rank[rootP] > rank[rootQ])
            parent[rootQ]= rootP;
        else{
            //rank are same
            parent[rootP]= rootQ;
            rank[rootQ]++;
        }
        count--;
    }
    
    //Return count;
    public int count(){
        return count;
    }
}

public class DisjointSet {
	
	private static int findCircle(int  [][] isConnected) {
		int n=isConnected.length;
        UnionFind uf= new UnionFind(n);
        //Disjoint set
        
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n; j++){
                if(isConnected[i][j] == 1) 
                    uf.union(i, j);
            }
        }
        return uf.count();
	}
	
	public static void main(String[] args) {
		int isConnected[][]= {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircle(isConnected));
	}

}
