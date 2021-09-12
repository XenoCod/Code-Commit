package Stack;

import java.util.Stack;

public class AstoriodCollision {
	void getCollision(int nums[]) {
		Stack<Integer> st= new Stack<>();
        for(int i:nums){
            if(i>0) st.push(i);
            else{
                //when the element is negetive
                while(!st.isEmpty() && st.peek() >0 && st.peek() < Math.abs(i)) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(i);
                else if(i+ st.peek() == 0) st.pop();//whem equal
            }
        }
        int res[]= new int [st.size()];
        for(int i=res.length-1; i>=0;i--)
            res[i]= st.pop();
        for(int i:res) System.out.print(i+" ");
	}
	public static void main(String[] args) {
		AstoriodCollision obj= new AstoriodCollision();
		obj.getCollision(new int [] {5, 10, -5});
		
	}

}
