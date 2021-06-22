package Codes.Arrays;

import java.util.Scanner;

public class MoveZerosToEnd {
    static void swap(int arr[],int a, int b){
       int temp=arr[a];
       arr[a]=arr[b];
       arr[b]=temp;

    }
    static void move(int arr[], int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                swap(arr,i, count);
                count++;
            }
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
        move(arr, n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);

    }
}
