package Codes.DynamicProgramming;

public class RodCuttiing {
    static int rodCut(int l[], int prices[], int N){
        int n=l.length;
        int dp[][]= new int [n+1][N+1];
        for(int i=0;i<=N;i++) dp[0][i]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        for(int i= 1;i<=n;i++){
            for(int j=1;j<=N;j++){
                if(l[i-1]<=j){
                    dp[i][j]=Math.max(prices[i-1]+dp[i][j-l[i-1]], dp[i-1][j]);

                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][N];
    }
    public static void main(String[] args) {
        int l[]={1,2,3,4,5,6,7,8};
        int prices[]={1,5,8,9,10,17, 17, 20};
        int N=8;
        System.out.println(rodCut(l, prices, N));

    }
}
