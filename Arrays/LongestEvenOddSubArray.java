package Codes.Arrays;

import java.util.Scanner;

public class LongestEvenOddSubArray {
    static int maxLength(int arr[], int n){
        //Kadane Algo
        int res=1;
        int count=1;
        for(int i=1;i<n;i++){
            if((arr[i]%2==0 && arr[i-1]%2!=0)|| (arr[i]%2!=0 && arr[i-1]%2==0)){
                count++;
                res=Math.max(res, count);
            }
            else
                count=1;
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
        System.out.println(maxLength(arr, n));
    }
}
