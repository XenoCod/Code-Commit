package Codes.DynamicProgramming;

public class MinCoinsRequired {
    static int minCoins(int arr[], int sum){
        int n=arr.length;
        int dp[][]= new int[n+1][sum+1];

        for(int i=0;i<=sum;i++) dp[0][i]=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++)   dp[i][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.min(dp[i][j-arr[i-1]]+1, dp[i-1][j]);

                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int sum=5;
        System.out.println(minCoins(arr, sum));
    }
}
