class Target_Sum{


	public static int findTargetSumWays(int[] nums, int target) {
        int zeros= 0;
        int sum=0;
        for(int i: nums){
            sum += i;
            if(i== 0) zeros++;
        }
        
        if(sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        int targetSum = (sum + target) /2;
        
        
        return (int) Math.pow(2, zeros) * countSubset(nums, targetSum);
    }


    private static int countSubset(int nums[], int target){
        int n= nums.length;
        int dp[][]= new int[n+1][target + 1];
        
        //Intilization
        for(int i=0; i<= n; i++) dp[i][0]= 1;
        for(int j=0; j<= target; j++) dp[0][j]= 0;
        
        dp[0][0]= 1;
        
        //
        for(int i=1; i<= n; i++){
            for(int j=1; j<= target; j++){
                
                if(nums[i-1] == 0){
                    dp[i][j]= dp[i-1][j];
                    continue;
                }
                
                if(j >= nums[i-1]){
                    dp[i][j]= dp[i-1][j- nums[i-1]] + dp[i-1][j];
                }
                
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }


	public static void main(String[] args) {
		int nums[]={1,1,1,1,1};
		int target=3;
				System.out.println(findTargetSumWays(nums, target));

		// Input: nums = [1,1,1,1,1], target = 3
		// Output: 5
		// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
		// -1 + 1 + 1 + 1 + 1 = 3
		// +1 - 1 + 1 + 1 + 1 = 3
		// +1 + 1 - 1 + 1 + 1 = 3
		// +1 + 1 + 1 - 1 + 1 = 3
		// +1 + 1 + 1 + 1 - 1 = 3

	}
}