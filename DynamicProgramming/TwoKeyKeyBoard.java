class TwoKeyKeyBoard{

	static private int minSteps(int n){
		 if(n == 1) return 0;
        if(n == 2) return 2;
        
        
        int dp[]= new int [n + 1];
        dp[1] = 0;
        dp[2]= 2;
        
        for(int i= 3; i<=n; i++){
            dp[i] = i;//Since to get ans one of the option is to copy it n times
            
            int j= i / 2;
            //SInce the max multiple of n should start from n /2 
            while(j >= 1){
                if(i % j == 0){
                    dp[i]= Math.min(dp[i], dp[j] + i / j);
                    break;
                }
                j--;
            }
        }
        
     return dp[n];  
	}


	public static void main(String[] args) {

// Input: n = 3
// Output: 3
// Explanation: Intitally, we have one character 'A'.
// In step 1, we use Copy All operation.
// In step 2, we use Paste operation to get 'AA'.
// In step 3, we use Paste operation to get 'AAA'.
			int n=3;
					System.out.println(minSteps(n));

	}
}