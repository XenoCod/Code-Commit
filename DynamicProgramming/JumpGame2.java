package DynamicProgramming;

public class JumpGame2 {
	static void minJumps(int nums[]) {
//		if(nums.length == 1) return 0;
        int n= nums.length;
        int currFarthest=0, currEnd=0, jumps=0;
        for(int curr=0; curr< n-1; curr++){
            currFarthest = Math.max(currFarthest, curr + nums[curr]);
            
            if(curr == currEnd){
                currEnd= currFarthest;
                jumps++;
                
                if(currEnd >= n-1) break;
            }
        }
//        return jumps;
        System.out.println("min jumps to reach the end => "+ jumps);
	}
	public static void main(String[] args) {
		int nums[]= {2,3,1,1,4};
		minJumps(nums);
		
	}

}
