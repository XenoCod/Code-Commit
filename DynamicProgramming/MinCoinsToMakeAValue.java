package Codes.DynamicProgramming;

import java.util.Arrays;

public class MinCoinsToMakeAValue {
    static int minCoins(int coins[], int val){
        int dp[]= new int [val+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=val;i++){
            for(int j=0;j<coins.length;j++){
                    if(coins[j]<=i){
                        int subResult=dp[i-coins[j]];
                        if(subResult!=Integer.MAX_VALUE)
                            dp[i]=Math.min(dp[i], subResult+1);
                    }
            }

        }
        return dp[val];
    }
    public static void main(String[] args) {
        int coins[]={3,4,1};
        int val=5;
        System.out.println(minCoins(coins, val));
    }
}
