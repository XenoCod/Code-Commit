package Codes.DynamicProgramming;

public class MatrixChainMultipilication {
    static int mcm(int arr[], int i, int j){
        if(i>=j)
            return 0;
        int res=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++) {
            int minCost = (mcm(arr, i, k) + mcm(arr, k + 1, j) + (arr[i-1] * arr[k] * arr[j]));
            res = Math.min(res, minCost);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={40, 20, 30, 10, 30};
        System.out.println(mcm(arr,1, arr.length-1));
    }
}
