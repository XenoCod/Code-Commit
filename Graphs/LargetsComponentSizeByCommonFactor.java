class UnionFind{
    private int[] parent, rank;
    private int components;
    
    public UnionFind(int n){
        parent= new int[n];
        rank= new int[n];
        components=n;
        
        for(int i=0;i< n; i++)
            parent[i] = i;
    }
    
    public int findParent(int node){
        
        while(node != parent[node]){
            parent[node]= parent[parent[node]];
            node= parent[node];
        }
        return node;
    }
    
    
    public void union(int p, int q){
        int rootP= findParent(p);
        int rootQ= findParent(q);
        
        if(rootP == rootQ) return;
        
        if(rank[rootP] > rank[rootQ]) parent[rootQ]= rootP;
        else if(rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else{
            parent[rootP]= rootQ;
            rank[rootQ]++;
        }
        components--;
    }
    
    
}



class Solution {
    public int largestComponentSize(int[] nums) {
        //Find the max val
        int maxVal= -1;
        for(int i: nums){
            maxVal= Math.max(maxVal, i);
        }
        
        //make a union find class with the max number of node
        UnionFind uf= new UnionFind(maxVal + 1);
        for(int num: nums){
            //Find all the prime factors
            for(int j=2; j*j <= num; j++){
                if(num % j == 0){
                    uf.union(num, j);
                    uf.union(num, num / j);
                }
            }
        }
        
        int res= Integer.MIN_VALUE;
        Map<Integer, Integer> map= new HashMap<>();
        for(int i: nums){
            //Find the parent of each val in nums and stire in the map and get the max element having the max children associated with it
            int val= uf.findParent(i);
            map.put(val, map.getOrDefault(val, 0) + 1);
            res= Math.max(res, map.get(val));
        }
        
        return res;
    }
}