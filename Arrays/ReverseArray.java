package Codes.Arrays;

import java.util.Scanner;

public class ReverseArray {
    static void reverse(int arr[], int start, int end){
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        reverse(arr, 0,arr.length-1);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);

    }
}
