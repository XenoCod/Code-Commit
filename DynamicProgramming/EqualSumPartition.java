package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.SubsetSum.subsetSum;

public class EqualSumPartition {
    static boolean equalSum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        if(sum%2==0)
            return subsetSum(arr,sum/2);
        else
            return false;
    }
    public static void main(String[] args) {
        int arr[]={1, 5, 11, 5};
        System.out.println(equalSum(arr));
    }
}
