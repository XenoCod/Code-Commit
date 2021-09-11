package Stack;

import java.util.Stack;

public class SumOfSubarrayMins {
	void getMins(int nums[]) {
		//Next smaller on the left
        //Next smaller on the right
        int n= nums.length;
        int nsl[]= new int [n];
        int nsr[]= new int [n];
        
        Stack<int []> st= new Stack<>();//Storing number, index
        
        //Next smaller on the left
        for(int i=0; i<n;i++){
            while(!st.isEmpty() && nums[i] <= st.peek()[0]) st.pop();
            
            nsl[i]= st.isEmpty() ? i+1: i - st.peek()[1];
            st.push(new int[] {nums[i], i});
        }
        
        //Empty the stack to resue
        while(!st.isEmpty()) st.pop();
        
        //Next Smaller on the right
        //Filing from the back
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[i] < st.peek()[0]) st.pop();
            
            nsr[i]= st.isEmpty() ? n-i: st.peek()[1] - i;
            st.push(new int [] {nums[i], i});
        }
        
        long mod= (long)1e9 + 7;
        long res=0;
        for(int i=0; i<n; i++){
            res=  (res + (long)nums[i] * nsl[i] * nsr[i]) % mod;
        }
        System.out.println((int)(res % mod));
        
        
        // For example [7 8 4 3], there is no PLE for element 4, so left[2] = 2+1 =3.
        // How many subarrays with 4(A[2]) being its minimum value?
        // It's left[2]*right[2]=3*1.
        // So the default value i+1 for left[i] and the default value n-i for right[i] are for counting the                 subarrays conveniently.
        
        // How does the multiplication gives us the no of subarrays. Anser in th link
        
        // https://lh3.googleusercontent.com/-GyygvrTJ3GY/XRlvmDTxEHI/AAAAAAAAO4E/yDc-Xvo3isgM8QFOSiVp6yUK_j9E8cwGACK8BGAs/s0/2019-06-30.jpg
        
        
        
	}
	public static void main(String[] args) {
		int nums[]= {3,1,2,4};
		SumOfSubarrayMins obj= new SumOfSubarrayMins();
		obj.getMins(nums);
	}

}
