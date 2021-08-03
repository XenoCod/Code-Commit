package Codes.DynamicProgramming;

import java.util.Arrays;

public class MemoziedMCM {
    static int dp[][]= new int [1001][1001];
    static int mcmMemozied(int arr[], int i, int j){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        dp[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            dp[i][j]=Math.min(dp[i][j], mcmMemozied(arr, i, k)+mcmMemozied(arr, k+1, j)+arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];

    }
    public static void main(String[] args) {
        int arr[]={40, 20, 30, 10, 30};
        for(int [] row:dp)
            Arrays.fill(row, -1);
        System.out.println(mcmMemozied(arr, 1, arr.length-1));
    }
}
