package Codes.DynamicProgramming;

public class EditDistance {
    //Iterative approach
    static int ed(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1+Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i-1][j]));

        }
        return dp[m][n];
    }

    //Recursive approach
    static int edRec(String s1, String s2, int m , int n){
        if(m==0)
            return n;
        if(n==0)
            return m;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return edRec(s1, s2, m-1, n-1);
        else
            return 1+Math.min(edRec(s1, s2, m-1, n-1), (Math.min (edRec(s1, s2, m, n-1), edRec(s1, s2,m-1,n))));
    }


    public static void main(String[] args) {
        String s1="SATURDAY",s2="SUNDAY";
        System.out.println(ed(s1, s2));
        System.out.println(edRec(s1, s2, s1.length(), s2.length()));
        

    }
}
