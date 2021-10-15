public class MinCostTreeFromLeaf{
	int mctFromLeaf(int nums[]){
		int n= nums.length;
		int memo[][]= new int[n][n];
		return solve(nums, 0, n-1, memo);
	}

	int solve(int nums[], int startIndex, int endIndex, int memo[][]){
		if(startIndex >= endIndex) return 0;

		if(memo[startIndex][endIndex] != 0) return memo[startIndex][endIndex];

		int res=Integer.MAX_VALUE;
		for(int k=startIndex; k< endIndex; k++){

			int rootVal= max(nums, startIndex, k) * max(nums, k+1, endIndex);

			int non_leaf_node_from_left_subtree= solve(nums, startIndex, k, memo);
			int non_leaf_node_from_right_subtree= solve(nums, k+1, endIndex, memo);

			res= Math.min(res, rootVal + non_leaf_node_from_right_subtree + non_leaf_node_from_left_subtree);


		}
		memo[startIndex][endIndex]= res;
		return res;
	}

	private int max(int nums[], int l, int r){
		int res= Integer.MIN_VALUE;
		for(int i=l; i<=r; i++)
			res = Math.max(res, nums[i]);
		return res;
	}
	public static void main(String[] args) {
		int nums[]={6,2,4};
		MinCostTreeFromLeaf obj= new MinCostTreeFromLeaf();
		System.out.println(obj.mctFromLeaf(nums));
	}
}