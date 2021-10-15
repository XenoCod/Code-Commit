public class MinCostTreeFromLeaf{
	static int mctFromLeaf(int nums[]){
		int n= nums.length;
		int memo[][]= new int[n][n];
		return solve(nums, 0, n-1, memo);
	}

	private static int solve(int nums[], int startIndex, int endIndex, int memo[][]){
		if(startIndex >= endIndex) return 0;

		if(memo[startIndex][endIndex] != 0) return memo[startIndex][endIndex];

		int res=Integer.MAX_VALUE;
		for(int k=startIndex; k< endIndex; k++){

			int left= solve(nums, startIndex, k, memo);
			int right= solve(nums, k+1, endIndex, memo);

			int leftMax=0, rightMax=0;

			for(int i=startIndex; i<=k; i++) leftMax= Math.max(leftMax, nums[i]);

			for(int i=k+1; i<=endIndex; i++) rightMax= Math.max(rightMax, nums[i]);

			int nonLeafNode= leftMax * rightMax;

			res= Math.min(res, nonLeafNode + left + right);
		}
		memo[startIndex][endIndex]= res;
		return res;
	}
	public static void main(String[] args) {
		int nums[]={6,2,4};
		System.out.println(mctFromLeaf(nums));
	}
}