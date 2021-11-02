import java.util.Set;
import java.util.HashSet;


class SubArraysBitwiseOr{

	private static int subArraysBitwiseOr(int nums[]){
		//Fix i and run j from i to n-1
        //res will strres the unique val
        Set<Integer> curr= null, prev= new HashSet<>(), res= new HashSet<>();
        
        for(int currNum: nums){
            curr= new HashSet<>();
            prev.add(0);
            
            for(int prevNum: prev){
                curr.add(prevNum | currNum);
                res.add(prevNum | currNum);
            }
            
            prev= curr;
        }
        
        return res.size();
	}


	public static void main(String[] args) {

// Input: arr = [1,1,2]
// Output: 3
// Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
// These yield the results 1, 1, 2, 1, 3, 3.
// There are 3 unique values, so the answer is 3.

		int nums[]={1,1,2};
				System.out.println(subArraysBitwiseOr(nums));

	}
}