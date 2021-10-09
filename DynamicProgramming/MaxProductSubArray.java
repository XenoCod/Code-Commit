package DynamicProgramming;

public class MaxProductSubArray {
	static void getMax(int nums[]) {
		int n= nums.length;
		int currMax[]= new int[n];//stores the currMax value till now
		int currMin[]= new int[n];//stores the currMin value till now
		
		currMax[0]= currMin[0]= nums[0];
		int ans= Integer.MIN_VALUE;
		
		for(int i=1; i< n; i++) {
			currMax[i] = Math.max(nums[i] * currMax[i-1], Math.max(currMin[i-1] * nums[i], nums[i]));
			//Since there could be 3 options for us to currMax
//			1. the current nums[i] is the max we have encounteres
//			2. Since positive * positive  will give us the large positive
//			3. Since negetive * negetive will also give us a large postive 
			
//			so we take the max of all the 3 possibilities
			currMin[i]= Math.min(nums[i] * currMax[i-1], Math.min(currMin[i-1] * nums[i], nums[i]));
			
			ans= Math.max(ans, currMax[i]);
			
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int nums[]= {2,3,-2,4};
		getMax(nums);
	}

}
