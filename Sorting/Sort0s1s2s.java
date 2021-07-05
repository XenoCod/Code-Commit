package Codes.Sorting;

import java.util.Scanner;

public class Sort0s1s2s {
    static void swap(int arr[], int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    //Using the Dutch National Flag Algo
    static void sort(int arr[], int n){
        int low=0, mid=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
//                int temp=arr[low];
//                arr[low]=arr[mid];
//                arr[mid]=temp;
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1)
                mid++;

            else {
//                int temp=arr[mid];
//                arr[mid]=arr[high];
//                arr[high]=temp;
                swap(arr, mid, high);
                high--;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        sort(arr, n);
       for(int i=0;i<n;i++)
           System.out.println(arr[i]);
    }
}
