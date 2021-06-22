package Codes.Arrays;

import java.util.Scanner;

public class LeftRotateByDtimes {
    static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static void leftRotatebyD(int arr[], int n, int d){
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the D times");
        int d=sc.nextInt();
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        leftRotatebyD(arr,n, d);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
