import java.util.Arrays;
class MinDiff{

	private static int minDiff(int nums[]){
		    int n= nums.length;
        if(n < 5) return 0;
        
        Arrays.sort(nums);
        int moves= 4;
        int left=0, right = n- 4;
        int res= Integer.MAX_VALUE;
        
        while(moves > 0){
            res = Math.min(res, nums[right]- nums[left]);
            left++;
            right++;
            moves--;
        }
        return res;
        
        
	}


	public static void main(String[] args) {
// Given an array nums, you are allowed to choose one element of nums and change it by any value in one move.

// Return the minimum difference between the largest and smallest value of nums after perfoming at most 3 moves.

 

// Example 1:

// Input: nums = [5,3,2,4]
// Output: 0
// Explanation: Change the array [5,3,2,4] to [2,2,2,2].
// The difference between the maximum and minimum is 2-2 = 0.
		int nums[]={5,3,2,4};
				System.out.println(minDiff(nums));



	}
}