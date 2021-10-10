package DynamicProgramming;

public class PartitionToKEqualSumSubsets {
	static boolean canPartition(int nums[], int k) {
		//This can also be called as find all the combination of sum /k subsets in the array
		int sum=0;
		for(int i: nums) sum += i;
		
		int target= sum /k;
		boolean isTaken[]= new boolean[nums.length];
		
		if(sum % k != 0) return false; //if the array is not completely divisible by k then we can't parition it
		
		return solve(nums, k, isTaken, 0, target, 0);
		
	}
	
	private static boolean solve(int nums[], int k, boolean isTaken[], int sum , int target, int index) {
		if(k == 1) return true; //once we reach this statment it means we have calculated for k-1 combination so the remaining is true always
		
		if(sum == target)
			return solve(nums, k-1, isTaken, 0, target, 0);
		
		for(int i=index; i< nums.length; i++) {
			
			if(!isTaken[i]) {
				isTaken[i]= true;
				
				if(solve(nums, k, isTaken, sum + nums[i], target, i+1))
					return true;
				
				isTaken[i]= false;
				
				
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int nums[]= {4,3,2,3,5,2,1};
		int k=4;
		System.out.println(canPartition(nums, k));
		
	}
}
