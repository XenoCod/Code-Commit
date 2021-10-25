class LongestTurbulentSubArray{

	static int longestTubSubarray(int nums[]){
		
        if(nums.length == 1) return 1;
        
        int inc =1, dec=1;
        int res= 0;
        int n= nums.length;
        
       for(int i=0; i<n-1; i++){
           if(nums[i] < nums[i+1]){
               inc = dec + 1;
               dec =1;
           }
           else if(nums[i] > nums[i+1]){
               dec = inc + 1;
               inc =1;
           }
           else{
               inc =1;
               dec =1;
           }
           
           res= Math.max(res, Math.max(inc, dec));
       }
        return res;
	}
	public static void main(String[] args) {
		int nums[]={9,4,2,10,7,8,8,1,9};
		//find the longest subarrat which satisfy the condition
		 // curr -1 < curr > curr + 1 
		 // or 
		 // curr -1 > curr < curr + 1

				System.out.println(longestTubSubarray(nums));
	}
}