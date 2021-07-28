package Codes.DynamicProgramming;

import java.util.Arrays;

public class LongestSubsequence {
    static int memo[][];
    static int lcsRec(String s1, String s2, int n, int m){
        if(n==0 || m==0)
            memo[n][m]=0;
        if(memo[n][m]!=-1)
            return memo[n][m];
        else {
            if(s1.charAt(n-1)== s2.charAt(m-1))
                memo[n][m]= 1+lcsRec(s1, s2, n-1, m-1);
            else
                memo[n][m]=Math.max(lcsRec(s1, s2, n-1,m), lcsRec(s1, s2,n, m-1));

        }
        return memo[n][m];
    }

    public static void main(String[] args) {
        String s1="ABCDGH";
        String s2="AEDFHR";
        int n=s1.length(), m=s2.length();
        memo= new int [n+1][m+1];
        for(int []i:memo)
            Arrays.fill(i, -1);

        System.out.println(lcsRec(s1, s2, n,m));
    }
}
