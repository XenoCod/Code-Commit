package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.LCS.lcs;

public class LongestRepeatingSubsequence {
    static int longestRepeating(String a){
        String b=a;
        int m=a.length(), n=a.length();
        int dp[][]= new int [m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)== b.charAt(j-1) && i!=j)
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String a="AABEBCDD";
        System.out.println(longestRepeating(a));
    }
}
