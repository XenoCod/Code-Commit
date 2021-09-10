package Stack;

import java.util.HashMap;
import java.util.Stack;

public class StockSpanProblem {
	void stockSpan(int nums[]) {
		 Stack<Integer> st= new Stack<>();
			
			
			
			int res[]= new int [nums.length];
			for(int i=0; i< nums.length; i++) {
				if(st.isEmpty())  res[i]= 1;
				else {
					while(!st.isEmpty() && nums[i] >= nums[st.peek()]) st.pop();
					
					res[i]= st.isEmpty() ? i+1: i- st.peek();
				}
				st.push(i);
			}
		
		for(int i:res) System.out.print(i+" ");
	}
	public static void main(String[] args) {
		int nums[]= {100, 80, 60, 70, 60, 75, 85};
		StockSpanProblem obj= new StockSpanProblem();
		obj.stockSpan(nums);
	}
}
