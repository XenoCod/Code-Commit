package DynamicProgramming;

public class HouseRobber {
	static void rob(int nums[]) {
//		 if(nums.length == 1) return nums[0];        // if there is only one house rob it
	        
	        //when there are 2 houses
	        int n= nums.length;
	        int dp[]= new int [n];
	        
	        //when there are only 1 houses the max robbed amount the val of 1st house only
	        dp[0]= nums[0];
	        
	        //when we are house 2 that is next to 1st house we have 2 choice whe the to robbed 1st or 2nd house, we only the rob with the max val
	        dp[1]= Math.max(nums[0], nums[1]);
	        
	        for(int i=2; i< n; i++){
	            //when we are the 3rd house we can either robbed the 3rd house + 1st house or rob the 2nd house
	            dp[i]= Math.max(nums[i]/*current house val*/ + dp[i-2]/*previous to previous house*/, dp[i-1]/* the prev house*/);
	        }
	        System.out.println(dp[n-1]);
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3,1};
		//Given an integer array nums representing the amount of money of each house, return the 
		//maximum amount of money you can rob tonight without alerting the police.
		
		//Can't rob adjacent houses
		rob(nums);
	}
}
