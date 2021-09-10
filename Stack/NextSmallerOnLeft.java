package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerOnLeft {
	void nsel(int nums[]) {
		Stack<Integer> st= new Stack<>();
		ArrayList<Integer> list= new ArrayList<>();
		
		for(int i=0; i< nums.length; i++) {
			if(st.isEmpty()) list.add(-1);
			else {
				while(!st.isEmpty() && nums[i] <= st.peek()) st.pop();
				if(st.isEmpty()) list.add(-1);
				else list.add(st.peek());
			}
			
			st.push(nums[i]);
		}
		
		
		System.out.println(list);
	}
	public static void main(String[] args) {
		
		int nums[]= {2,1,5,6,2,3};
		NextSmallerOnLeft obj= new NextSmallerOnLeft();
		obj.nsel(nums);
	}

}
