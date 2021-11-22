package Codes.Arrays;

import java.util.Scanner;

public class FreuenciesOfElement {
    static void frequecies(int arr[], int n){
        int i=1, freq=1;
        while(i<n){
            while(i<n && arr[i]==arr[i-1]){
                i++;
                freq++;

            }
            System.out.println(arr[i-1]+" "+freq);
            freq=1;
            i++;
        }
        if(n==1 || arr[n-1]!=arr[n-2])
            System.out.println(arr[n-1]+" 1" );
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        frequecies(arr,n);

    }
}
