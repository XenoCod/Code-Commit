package DynamicProgramming;

public class IntegerBreak {
	static void getMaxProduct(int n) {
		int dp[]= new int[n+1];
		dp[1]=1;//we can get atmost product of 1 after breaking it;
		for(int i=2; i<=n; i++) {
			 //for example for n=8
            // (8,1),(7,2),(6,3),(5,4),(4,3),(3,2),(2,1),(1,0)
            // dp[8]= max(dp[8], max(j, dp[j]) * max(i-j, dp[i-j]))
			for(int j=1; j<=i/2; j++) {
				dp[i]= Math.max(dp[i],  Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
			}
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
//	Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
//
//			Return the maximum product you can get.
		int n=10;
//		Output: 36
//		Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
		getMaxProduct(n);
	}
}
