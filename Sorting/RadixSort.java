package Codes.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    static void countSort(int arr[], int n, int exp){
        int counts[]= new int [n];
        int outputs[]= new int [n];
        Arrays.fill(counts, 0);

        for(int i=0;i<n;i++)
            counts[(arr[i]/exp)%10]++;
        for(int i=1;i<n;i++)
            counts[i]=counts[i]+counts[i-1];
        //This expression will the each digits occurenecs
        for(int i=n-1;i>=0;i--){
            outputs[counts[(arr[i]/exp)%10]-1]=arr[i];
            counts[(arr[i]/exp)%10]--;
        }
        for(int i=0;i<n;i++)
            arr[i]=outputs[i];

    }

    static void radixSort(int arr[], int k, int n){
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(arr[i], max);

        for(int exp=1;max/exp>0;exp=exp*10)
            countSort(arr, n, exp);



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
        radixSort(arr, k,n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
