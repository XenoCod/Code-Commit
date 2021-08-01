package Codes.DynamicProgramming;

public class MaxWaysForCoinChange {
    static int maxWays(int arr[], int sum){
        int n=arr.length;
        int dp[][]= new int[n+1][sum+1];
        for(int i=0;i<=sum;i++)  dp[0][i]=0;
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i][j-arr[i-1]]+ dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int sum=5;
        System.out.println(maxWays(arr, sum));
    }
}
