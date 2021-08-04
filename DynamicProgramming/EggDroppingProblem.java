package Codes.DynamicProgramming;

import java.util.Arrays;

public class EggDroppingProblem {
    static int dp[][]= new int [1001][1001];
    static int solveEggDrop(int egg, int floor){
        if(egg==1) return floor;
        if(floor==1 || floor==0) return floor;
        if (dp[egg][floor]!=-1) return dp[egg][floor];

        int l=0, h=floor, ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=(l+h)/2;
            int down_temp=solveEggDrop(egg-1,mid-1);// egg breaks go down
            int up_temp= solveEggDrop(egg, floor-mid);//egg doesn't break go up
            int temp=1+Math.max(down_temp, up_temp);//we need the worst case

            if(down_temp<up_temp) l=mid+1;
            else h=mid-1;
            ans=Math.min(temp, ans);//finding min attempts

        }
        return dp[egg][floor]=ans;

    }
    public static void main(String[] args) {
        int egg=2, floor=10;
        for(int row[]:dp)
            Arrays.fill(row, -1);
        System.out.println(solveEggDrop(egg, floor));
    }
}
