package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Leetcode 1376

public class TimeToReachAllNodes {
	void findTime(int n, int headId, int manager[], int informTime[]) {
		 Map<Integer, ArrayList<Integer>> map= new HashMap<>();
		 for(int i=0; i<manager.length; i++) {
			 if(!map.containsKey(manager[i]))
				 map.put(manager[i], new ArrayList<>());
			 
			 map.get(manager[i]).add(i); 		//mapping all the manager aand their subordinates
		 }
		 
		 Queue<int []> q= new LinkedList<>();
		 q.add(new int[] {headId, 0});
		 int res= Integer.MIN_VALUE;
		 while(!q.isEmpty()) {
			 int curr[]= q.poll();
			 int managerAtCurrLevel= curr[0];
			 int timeTakenToReachCurrLevel= curr[1];
			 
			 res= Math.max(res, timeTakenToReachCurrLevel);
			 
			 if(map.containsKey(managerAtCurrLevel)) {
				 List<Integer> subordinates= map.get(managerAtCurrLevel);
				 
				 for(int i:subordinates)
					 q.add(new int[] {i, informTime[managerAtCurrLevel] + timeTakenToReachCurrLevel});
			 }
		 }
		 System.out.println(res);
	}
	public static void main(String[] args) {
		int n=6, headId=2;
		int manager[]= {2,2,-1,2,2,2};
		int informTime[]= {0,0,1,0,0,0};
		
		
		TimeToReachAllNodes obj= new TimeToReachAllNodes();
		obj.findTime(n, headId, manager, informTime);
	}

}
