import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       //Checking if there exist a sol
        int total= 0;
        int n= gas.length;
        for(int i=0; i<n; i++)
            total += gas[i] - cost[i];
        
        if(total < 0) return -1;
        
        int tank=0;
        int start=0;
        for(int i=0; i< n; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                start =i +1;
                tank =0;
            }
        }
        return start;
    }
}

class GasStation{
	public static void main(String[] args) {
		Solution obj= new Solution();
		int gas[]={1,2,3,4,5};
		int cost[]={3,4,5,1,2};
				System.out.println(obj.canCompleteCircuit(gas, cost));
	}
}