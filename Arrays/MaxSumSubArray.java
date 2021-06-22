package Codes.Arrays;

import java.util.Scanner;

public class MaxSumSubArray {
    static int maxSum(int arr[], int n){
        int sum=arr[0];
        int res=0;
        for(int i=1;i<n;i++){
            sum=Math.max(arr[i]+sum, arr[i]);
            res=Math.max(sum, res);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(maxSum(arr,n));
    }
}
