package Codes.DynamicProgramming;

public class KnapSack01 {
    static int knapSack(int wt[], int val[], int weight){
        int n=wt.length;


        int dp[][]= new int[n + 1][weight + 1];

        for(int i=0; i<=weight; i++) {
            dp[0][i] = 0;
        }

        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=weight;j++){
                if(wt[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n][weight];
    }
    public static void main(String[] args) {
        int val[]={10, 40, 30, 50};
        int wt[]={5,4,6,3};
        int weight=10;
        System.out.println(knapSack(wt, val, weight));
    }
}
