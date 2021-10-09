package DynamicProgramming;

public class MaxLengthOfSubarrayWithPostiveProduct {
	static void getMaxLen(int nums[]) {
int n= nums.length;
        
        // there can be 3 instances when the max len can be form
        //     1. when all the number are +ve 
        //     2. when there are even number in the sub array
        //     3. when there are zeros we take from the zero postin to the current
        
        int zeroPos=-1, negetiveCount=0, _1stnegetiveIndex=-1, max= 0;
        for(int i=0; i< n; i++){
            if(nums[i] < 0){
                negetiveCount++;
                
                if(_1stnegetiveIndex == -1) _1stnegetiveIndex =i;
            }
            
            if(nums[i] == 0){
                // whenever we encounter a zero we just resest all our value
                zeroPos = i;
                _1stnegetiveIndex =-1;
                negetiveCount =0;
            }
            else{
                //when there are even # of negetive elemnts or all positive element
                if(negetiveCount % 2 ==0) max= Math.max(max, i - zeroPos);
                
                else max= Math.max(max, i - _1stnegetiveIndex);
            }
        }
//        return max;
        System.out.println(max);
	}
	public static void main(String[] args) {
		int nums[]= {1, -2, -3, 4};
		getMaxLen(nums);
		
	}

}
