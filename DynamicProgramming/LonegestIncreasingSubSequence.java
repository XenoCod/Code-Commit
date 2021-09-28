package DynamicProgramming;

import java.util.Arrays;

public class LonegestIncreasingSubSequence {
	static void getLCS(int nums[]) {
		int dp[]= new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i=0; i< nums.length; i++) {
			dp[lowerBound(dp, nums[i])]= nums[i];
		}
		//for 1st case the dp array would be 
        // 2 3 7 18 2147483647 2147483647 2147483647 2147483647 
		System.out.println( lowerBound(dp, Integer.MAX_VALUE));
	}
	
	private static int lowerBound(int nums[], int key) {
		//This function always returns the lower bound of the key using binary search
		int low= 0, high= nums.length;
		while(low < high) {
			int mid= low + (high - low) /2;
			if(nums[mid] >= key)
				high= mid;
			else low = mid+1;
		}
		return low;
	}
	public static void main(String[] args) {
		int nums[]= {10,9,2,5,3,7,101,18};
		getLCS(nums);
	}

}
