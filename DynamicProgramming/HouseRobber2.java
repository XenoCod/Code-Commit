package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
	static void robMax(int nums[]) {
//		/for only 1 house
//        if(nums.length == 1) return nums[0];
        
        //for rest of the cases
        int n= nums.length;
        //Here we using the dividng it into 2 subproblem i.e
        //1st subproblem= what would be max Amt we can rob by robbing from house 1 to penultimate house
        
        //2nd subproblem = what would the max amt we can rob by robbing from house 2 to last house
//        return Math.max(getMaxAmt(nums, 0, n-2), getMaxAmt(nums, 1, n-1));
				System.out.println(Math.max(getMaxAmt(nums, 0, n-2), getMaxAmt(nums, 1, n-1)));
	}
	
	 static private int getMaxAmt(int arr[], int start, int end){
	        int nums[]= Arrays.copyOfRange(arr, start, end+1); //creating a duplicate array to perform operations
	        
	        //Base Cases
	        if(nums.length == 0) return 0;
	        if(nums.length == 1) return nums[0];
	        
	        
	        int n=nums.length;
	        int dp[]= new int[n];
	        
	        //Resusing the same logic behind house robber 1
	        dp[0]= nums[0];
	        dp[1]= Math.max(nums[0], nums[1]);
	        
	        for(int i=2; i< n; i++){
	            dp[i]= Math.max(nums[i] + dp[i-2], dp[i-1]);
	        }
	        return dp[n-1];
	    }
	public static void main(String[] args) {
		int nums[]= {1,2,3,1};
		//Same as house robber but we houses are positioned circular 
		//1st house is adjacent to last house and vice versa
		robMax(nums);
	}

}
