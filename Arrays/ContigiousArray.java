class ContigiousArray{

	private static int findMaxContiiousArray(int nums[]){
		 Map<Integer, Integer> map= new HashMap<>();
        int res =0;
        int sum=0, index=0;
        map.put(0, -1);
        for(int i: nums){
            if(i == 0) sum++;
            else sum--;
            if(map.containsKey(sum)) res = Math.max(res, index - map.get(sum));
            else map.put(sum, index);
            index++;
        }
        return res;
	}

	public static void main(String[] args) {
// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

//  Example 1:

// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
		int nums[]={0,0,1,0,0,0,1,1};
				System.out.println(findMaxContiiousArray(nums));

	}
}