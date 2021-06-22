package Codes.Recursion;

import java.util.Scanner;

public class SubsetSum {
    static int subsetSum(int arr[], int n, int sum ){
        if(n==0)
            return (sum==0)?1:0;
        return subsetSum(arr,n-1,sum)+subsetSum(arr, n-1, sum-arr[n-1]);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input size");
        int n=sc.nextInt();
        System.out.println("Input sum");
        int sum=sc.nextInt();
        System.out.println("Enter elements");
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(subsetSum(arr, n,sum));

    }
}
