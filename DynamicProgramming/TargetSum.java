package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.CountSubsetWithGivenSum.subsetCountSum;

public class TargetSum {
    static int targetSum(int arr[], int target){
        int sum=0;

        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        int givenSum=(target+sum)/2;
        return subsetCountSum(arr, givenSum);
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1};
        int sum=3;
        System.out.println(targetSum(arr, sum));

    }
}
