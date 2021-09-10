package Stack;

import java.util.Stack;

public class MaxRectangleInHistogram {
	
	void getMaxRect(int nums[]) {
		int n= nums.length;
        //We make Next smaller left and Next greater right 
        //Then we calaculaye the max area with right - left -1;
        int nsl[]= new int [n];
        int nsr[]= new int [n];
        
        
        Stack<Integer> st1= new Stack<>();//STack for next smaller left
        Stack<Integer> st2= new Stack<>();//Stack for next smaller right
        
        //Next smaller left
        for(int i=0; i<n;i++){
            // if(st1.isEmpty()) nsl[i]= 0;
            // else{
                while(!st1.isEmpty() && nums[i] <= nums[st1.peek()]) st1.pop();
                if(st1.isEmpty()) nsl[i]=0;
                else nsl[i]= st1.peek()+1;
            // }
            
            st1.push(i);
        }
        
        //next smaller right
        for(int i=nums.length-1; i>=0; i--) {
//			if(st2.isEmpty()) list.add(-1);
			
				while(!st2.isEmpty() && nums[i] <= nums[st2.peek()]) st2.pop();//remove the top element if its greater than
				if(st2.isEmpty()) nsr[i]= n- 1;
				else nsr[i]= st2.peek()-1;
			
			
			st2.push(i);
		}
        
//        reverse(nsr, 0, n-1);
        for(int i:nsr) System.out.print(i+" ");
        System.out.println();
        for(int i:nsl) System.out.print(i+" ");
        
        int max=Integer.MIN_VALUE;
        for(int i=0; i< n;i++){
            max= Math.max(nums[i] * (nsr[i] - nsl[i] + 1), max);
            System.out.println(max);
        }
//       return max;
        
	}
	
	
	
	public static void main(String[] args) {
		int nums[]= {2,1,5,6,2,3};
		MaxRectangleInHistogram obj= new MaxRectangleInHistogram();
		obj.getMaxRect(nums);
	}
}
