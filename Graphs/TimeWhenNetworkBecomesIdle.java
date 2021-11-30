package Graphs;

public class TimeWhenNetworkBecomesIdle {
    List<List<Integer>> adj= new ArrayList<>();
    int n= patience.length;

        for(int i=0; i< n; i++){
        adj.add(new ArrayList<>());
    }

        for(int edge[]: edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    Deque<Integer> q= new ArrayDeque<>();
        q.add(0);
    int visited[]= new int[n];
    int level=0;

        while(!q.isEmpty()){
        int size= q.size();
        level++;
        for(int i=0; i< size; i++){
            int node= q.poll();
            for(int next: adj.get(node)){
                if(visited[next] == 0){
                    q.add(next);
                    visited[next] = 2 * level;
                }
            }
        }
    }

    int res=0;

        for(int i=1; i< visited.length; i++){
        int dist= visited[i];
        int val = dist + dist - (dist % patience[i]);
        if(dist % patience[i] == 0) val -= patience[i];
        res = Integer.max(res, val);
    }

        return res + 1;
}
}

