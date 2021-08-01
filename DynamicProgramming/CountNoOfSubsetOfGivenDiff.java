package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.CountSubsetWithGivenSum.subsetCountSum;

public class CountNoOfSubsetOfGivenDiff {
    static int count(int arr[], int diff){
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        int givenSum=(diff+sum)/2;
        return subsetCountSum(arr, givenSum);
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1};
        int diff=3;
        System.out.println(count(arr, diff));
    }
}
