package Codes.Arrays;

import java.util.Scanner;

public class LefftRotateArrayBy1 {
    static void leftRotate(int arr[], int n){
        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        leftRotate(arr,n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
