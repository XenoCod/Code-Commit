package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextLargerElement {
	void nge(int nums[]) {
		Stack<Integer> st= new Stack<>();
		ArrayList<Integer> list= new ArrayList<>();
		for(int i=nums.length-1; i>=0; i--) {
			if(st.empty()) list.add(-1);
			else {
				while(!st.isEmpty() && st.peek() <= nums[i]) st.pop();
				if(st.isEmpty()) list.add(-1);
				else list.add(st.peek());
			}
			st.push(nums[i]);
		}
		Collections.reverse(list);
		
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		int arr[]= {10,11,12,14,19,21,29};
		NextLargerElement obj= new NextLargerElement();
		obj.nge(arr);
	}

}
