package Codes.Arrays;

import java.util.Scanner;

public class MinConscutiveFlips {
    static void flips(int arr[], int n){
        //We can observe the minimmum flips to make all array
        // elements same would be to make the second distinct
        //element group flip
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                if(arr[i]!=arr[0]){
                    System.out.print("From "+i+" to ");
                }
                else
                    System.out.println(i-1);
            }
            if(arr[n-1]!=arr[0])
                System.out.println(n-1);
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
        flips(arr,n);
    }
}
