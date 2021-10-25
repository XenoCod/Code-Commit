class LongestFibbonaciSubseq{
	//DP with 2 sum
	static int lfs(int nums[]){
		int n= nums.length;
		int dp[][]= new int[n][n];
		int max=0;

		for(int i=2; i< n; i++){
			int l=0, r= i-1;
			while(l< r){
				int sum = nums[l] + nums[r] - nums[i];
				// since a + b == target
				if(sum > 0){
					r--;
				}

				else if(sum < 0){
					l++;
				}

				else{
					dp[r][i]= 1 + dp[l][r];
					max= Math.max(max, dp[r][i]);
					l++;
					r--;
				}
			}
		}
		return max == 0 ? 0 : max + 2;
	}
	public static void main(String[] args) {
		int nums[]={1,2,3,4,5,6,7,8};
		//ans= 5, {1,2,3,5,8};
				System.out.println(lfs(nums));
	}
}