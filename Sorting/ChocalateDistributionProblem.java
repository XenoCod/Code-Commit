package Codes.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ChocalateDistributionProblem {
    static int chocalate(int arr[], int m, int n){
        if(m>n)
            return -1;
        Arrays.sort(arr);
        int res=arr[m-1]-arr[0];
        for(int i=1;(i+m-1)<n;i++){
            res=Math.min(res,arr[i+m-1]-arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
//        int ar[]= {7, 3 , 2 ,4 ,9, 12 ,56};
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the value of m");
        int m=sc.nextInt();
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(chocalate(arr, m, n));
    }
}
