package DynamicProgramming;

public class JumpGame {
	static boolean canJump(int nums[]) {
		// DP definition: The farthest index we can reach given allowed steps from 0 to i
		// DP decision & relationship: It's either the dp[i - 1] or i + nums[i] whichever one is larger
		// DP condition:
		// If at any moment, dp[i] = 0, that means there is no way it can reach any further, return False immediately.
		// If at any moment, dp[i] >= last index, that means it can already reach the end of the array given the steps allowed from 0 to i, return True immediately.
		    
		        int n= nums.length;
		        int dp[]= new int [n];
		        dp[0]= nums[0];
		        if(n == 1) return true;
		        for(int i=1; i< n-1; i++){
		            if(dp[i-1] < i ) return false;
		            
		            dp[i]= Math.max(i+ nums[i], dp[i-1]);
		            
		            if(dp[i] >= n-1) return true;
		        }
		        return dp[n-2] >= n-1;
	}
	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));
//	Return true if you can reach the last index, or false otherwise.
	}
}
