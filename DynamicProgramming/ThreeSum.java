import java.util.*;

class ThreeSum{

	static List<List<Integer>> threeSum(int nums[]){
	
        List<List<Integer>> list= new ArrayList<>();
        int n= nums.length;
        if(n < 3) return list;
        
        Arrays.sort(nums);
        for(int i=0; i< n-2; i++){
            if(nums[i] > 0) break;  // If the starting val is more then 0 then three sum will not be zero
            
            if(nums[i] + nums[i+1] + nums[i+1] > 0) break;
            if(nums[i] + nums[n-1] + nums[n-2] < 0) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int low= i+1, high = n-1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    while(low < high && nums[high] == nums[high -1]) high--;
                    low++;
                    high--;
                }
                else if(sum < 0) low++;
                else high--;
            }
        }
        return list;
	}


	public static void main(String[] args) {
		int nums[]={-1,0,1,2,-1,-4};

		/*
		Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
		*/
				System.out.println(threeSum(nums));
	}
}