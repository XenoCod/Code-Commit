class OnesAndZeros{

	  public static int findMaxForm(String[] strs, int m, int n) {
        int dp[][]= new int[m+1][n+1];
        for(String s: strs){
            int count[]= getCount(s);
            //count[0]=zeros in curr string and count[1]= ones in curr str
            for(int zero=m; zero>= count[0]; zero--){
                for(int one=n; one >= count[1]; one--){
                    dp[zero][one]= Math.max(dp[zero - count[0]][one - count[1]] + 1, 
                                           dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }
    
    //retuns the count of zeros and ones in curr string
    private  static int[] getCount(String s){
        int count[]= new int[2];
        for(char c: s.toCharArray()){
            if(c == '0') count[0]++;
            else count[1]++;
        }
        return count;
    }




	public static void main(String[] args) {


// You are given an array of binary strings strs and two integers m and n.

// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

// A set x is a subset of a set y if all elements of x are also elements of y

// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
// Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
// {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

		String strs[]={"10","0001","111001","1","0"};
		int m=5, n=3;
				System.out.println(findMaxForm(strs, m, n));
	}
}