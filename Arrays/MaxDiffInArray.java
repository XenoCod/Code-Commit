package Codes.Arrays;

import java.util.Scanner;

public class MaxDiffInArray {
    static int maxDiff(int arr[], int n){
        int temp=arr[0];
        int res=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            temp=Math.min(temp,arr[i]);
            res=Math.max(res,arr[i]-temp);

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
        System.out.println(maxDiff(arr,n));

    }
}
