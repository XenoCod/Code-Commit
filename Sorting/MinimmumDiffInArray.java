package Codes.Sorting;

import java.util.Scanner;

public class MinimmumDiffInArray {
    static int minDiff(int arr[], int n){
        int max=0, secondMax=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else if(arr[i]>=secondMax){
                secondMax=arr[i];
            }
        }
        return max-secondMax;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(minDiff(arr, n));
    }
}
