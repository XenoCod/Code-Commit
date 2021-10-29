// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
import java.util.*;


class Longest_SubArray_With_Abs_Diff_Less_Than_or_equal_Limit{

	private static int findMax(int nums[], int limit){
		//The key is maintain two dequw maxDq nd minDq which maintina the order of the inserted element in decreasing order and increasing order respectiberlu
        
        Deque<Integer> maxDq= new ArrayDeque<>();
        Deque<Integer> minDq= new ArrayDeque<>();
        
        int end= 0, start=0, res=1;
        while(end < nums.length){
            
            while(!maxDq.isEmpty() && maxDq.peekLast() < nums[end]) maxDq.pollLast();
            maxDq.add(nums[end]);
            
            while(!minDq.isEmpty() && minDq.peekLast() > nums[end]) minDq.pollLast();
            minDq.add(nums[end]);
            
            while(maxDq.peekFirst() - minDq.peekFirst() > limit){
                if(maxDq.peekFirst() == nums[start]) maxDq.pollFirst();
                if(minDq.peekFirst() == nums[start]) minDq.pollFirst();
                start++;
            }
                
            res= Math.max(res, end - start + 1);
            end++;
        }
        return res;
	}


	public static void main(String[] args) {
		int nums[]={10,1,2,4,7,2};
		int limit= 5;
				System.out.println(findMax(nums, limit));

		// Input: nums = [10,1,2,4,7,2], limit = 5
		// Output: 4 
		// Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
	}
}