package Codes.DynamicProgramming;

public class LongestCommonSubString {
    static int longestSubString(String a, String b){
        int m=a.length(), n=b.length();
        int dp[][]= new int [m+1][n+1];

        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                if(i==0 || j==0)
                    dp[i][j]=0;

       for(int i=1;i<=m;i++){
           for(int j=1;j<=n;j++){
               if(a.charAt(i-1)==b.charAt(j-1))
                   dp[i][j]=1+dp[i-1][j-1];
               else
                   dp[i][j]=0;
           }
       }
       return dp[m][n];
    }
    public static void main(String[] args) {
        String a="SATURDAYY", b="SUNDAYY";
        System.out.println(longestSubString(a,b));
    }
}
