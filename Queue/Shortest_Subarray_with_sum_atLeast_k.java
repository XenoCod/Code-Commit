import java.util.*;

class Shortest_Subarray_with_sum_atLeast_k{

	private static int getMinArray(int nums[], int k){

        for(int i: nums) if( i>=k) return 1;
        
        Deque<Integer> dq= new LinkedList<>();
        int n= nums.length;
        long preSum []= new long[n + 1];
        
        //Filling the presum
        for(int i=0; i< n; i++){
            preSum[i+1]= preSum[i] + (long)nums[i];
        }
        
        int minLen= n + 1;
        for(int i=0; i< n + 1; i++){
           
              //Case 1: when we satisfy out condition
            while(!dq.isEmpty() && preSum[i] - preSum[dq.peekFirst()] >= k){
                minLen= Math.min(minLen, i - dq.pollFirst());
            }
            
            
            
            //Since we have to maintain a increasing order of presum val so we pop out the index fromt the end so that are less than curr pressum
            while(!dq.isEmpty() && preSum[i] <= preSum[dq.peekLast()]){
                dq.pollLast();
            }
            
            
           
            dq.add(i);
        }
        return minLen < n+ 1 ? minLen : -1;
	}


	public static void main(String[] args) {
			// Input: nums = [2,-1,2], k = 3
			// Output: 3
		int nums[]={2, -1, 2};
		int k=3;
				System.out.println(getMinArray(nums, k));
	}
}