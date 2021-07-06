package Codes.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    static void countSort(int arr[], int k, int n){
        int count[]= new int [k];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++)
            count[arr[i]]++;
        //counting all the elemenets smaller than current element
        for(int i=1;i<k;i++)
            count[i]=count[i]+count[i-1];
        //the output array to store sorted array
        int output[]= new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        for(int i=0;i<n;i++)
            arr[i]=output[i];

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n=sc.nextInt();
        System.out.println("Enter k");
        int k=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        countSort(arr, k, n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
