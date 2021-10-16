import java.util.*;

public class LongestArthimeticSequence{
	int las(int nums[]){
		int n= nums.length;
		HashMap<Integer, Integer> [] map= new HashMap[n]; 
		int res=1;

		for(int i=0; i<n; i++) 
			map[i]= new HashMap<>();

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				int diff=nums[i] - nums[j];
				map[i].put(diff, map[j].getOrDefault(diff, 0) +1);
				res= Math.max(res, map[i].get(diff));

			}
		}

		

		return res + 1;
	}
	public static void main (String[] args) {
		int nums[]={3,6,9,12};
		/*
		Input: nums = [3,6,9,12]
		Output: 4
		Explanation: 
		The whole array is an arithmetic sequence with steps of length = 3
		*/
		LongestArthimeticSequence obj= new LongestArthimeticSequence();
				System.out.println(obj.las(nums));
		
	}
}