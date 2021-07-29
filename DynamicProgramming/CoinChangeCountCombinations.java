package Codes.DynamicProgramming;

public class CoinChangeCountCombinations {
    static int coinChange(int coins[],int n, int sum){
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        int res=coinChange(coins, n-1, sum);
        if(coins[n-1]<=sum)
            res+=coinChange(coins, n, sum-coins[n-1]);
        return res;
    }
    public static void main(String[] args) {
        int coins[]= {2,5,3, 6};
        int sum=10;
        System.out.println(coinChange(coins,coins.length, sum));
    }
}
