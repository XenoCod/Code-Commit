package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterToLeft {
	void ngel(int nums[]) {
		ArrayList<Integer>  list= new ArrayList<>();
		Stack<Integer> st= new Stack<>();
		for(int i=0; i<nums.length;i++) {
			if(st.empty()) list.add(-1);//Base case since the 1st element is alays greater than left
			else {
				while(!st.isEmpty() && nums[i] >= st.peek()) st.pop();//Remove all the element from stack that are less than nums[i]
				if(st.isEmpty()) list.add(-1);//curr element is the largest
				else list.add(st.peek());
			}
			st.push(nums[i]);
		}
		
		
		System.out.println(list);
		
	}
	public static void main(String[] args) {
		int nums[]= {10,11,12,14,19,21,29};
//		int nums[]= {1, 3, 2, 4};
		NextGreaterToLeft obj= new NextGreaterToLeft();
		obj.ngel(nums);
		
	}
}
