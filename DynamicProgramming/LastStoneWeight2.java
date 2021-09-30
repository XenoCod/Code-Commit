package DynamicProgramming;

//let say array be [a,b,c,d]
//answer = (a+b)-(c+d) OR
//answer = a-(b+c+d) Or
//answer = (d+b)-(a+c) and so on.. any combination could be possible
//notice that in general I can say that
//answer = S1-S2
//where S1 is sum of some of the numbers and S2 is sum of rest of numbers
//also note that S1+S2 = SUM (sum of all numbers)
//S1 >= S2 beacuse negative answer is not possible
//now we have to minimise answer
//answer = SUM - 2*S2 (Just substituting S1 by SUM-S2)
//To minimise answer S2 has to be maximum
//Now, max value of S2 is SUM/2 (bigger than this and answer would be negative which is not possible)
//so the question reduces to find closest sum (sum of numbers) to (SUM/2)
//now this could be understood as subset sum problem or 0/1 knapsack problem


//Question 

//At the end of the game, there is at most one stone left.
//
//Return the smallest possible weight of the left stone. If there are no stones left, return 0

public class LastStoneWeight2 {
	
	static void getSmallestWeight(int nums[]) {
		int sum=0;
		for(int i: nums) sum += i;
		int total= sum;
		sum /= 2;
		
		
		int n= nums.length;
		int dp[][]= new int[n+1][sum+1];
		for(int i=1; i< n+1; i++) {
			for(int j=1; j< sum +1; j++) {
				if(nums[i - 1] > j) {
					dp[i][j]= dp[i-1][j];
				}
				else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j- nums[i-1]]+ nums[i-1]);
				}
			}
		}
		System.out.println(total - 2* dp[n][sum]);
	}
	
	public static void main(String[] args) {
//		int nums[]= {2,7,4,1,8,1};
		int nums[]= {31,26,33,21,40};
		getSmallestWeight(nums);
		
		
	}

}
