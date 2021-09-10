package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerOnRight {
	
	//Whenever calculating from the right Always reverse the list to get the output
	
	void nse(int nums[]) {
		Stack<Integer> st= new Stack<>();
		ArrayList<Integer> list= new ArrayList<>();
		
		for(int i=nums.length-1; i>=0; i--) {
			if(st.isEmpty()) list.add(-1);
			else {
				while(!st.isEmpty() && nums[i] <= st.peek()) st.pop();//remove the top element if its greater than
				if(st.isEmpty()) list.add(-1);
				else list.add(st.peek());
			}
			
			st.push(nums[i]);
		}
		
		Collections.reverse(list);
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		NextSmallerOnRight obj= new NextSmallerOnRight();
//		int nums[]= {1,4,6,2,5,9};
		int nums[]= {8,4,6,2,3};
		
		obj.nse(nums);
	}
}
