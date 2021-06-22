package Codes.Arrays;

import java.util.Scanner;

public class LeadersOfArray {
    static void leaders(int arr[], int n){
        int leader=arr[n-1];
        for(int i=n-2;i>0;i--){
            if(arr[i]>leader){
                leader=arr[i];
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.print(arr[n-1]+ " ");
        leaders(arr,n);

    }
}
