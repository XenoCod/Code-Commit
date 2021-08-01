package Codes.DynamicProgramming;

import java.util.ArrayList;

public class MinSubsetSumDiff {
    static boolean[][] subsetsum(int arr[], int sum){
        int n=arr.length;
        boolean dp[][]= new boolean [n+1][sum+1];
        for(int i=0;i<=sum;i++) dp[0][i]=false;
        for(int i=0;i<=n;i++) dp[i][0]=true;

        for(int i=1;i<=n;i++){
            for (int j=1;j<=sum;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp;
    }
    static int  minSubsetSum(int arr[]){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        boolean dp[][]= subsetsum(arr,sum);
        ArrayList<Integer> nums= new ArrayList<>();
        for(int i=0;i<=sum/2;i++)
            if(dp[n][i])
                nums.add(i);

        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++)
            res=Math.min(res, sum-2*nums.get(i));
        return res;
    }
    public static void main(String[] args) {
        int arr[]={3,5,6,1,8,10};
        System.out.println(minSubsetSum(arr));
    }
}
