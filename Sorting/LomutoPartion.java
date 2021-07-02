package Codes.Sorting;

import java.util.Scanner;

public class LomutoPartion {
    static int lomuto(int arr[], int n, int p){
        //We always assume the pivot is att the end of the array if the pivot is given we just swap the pivot element with last element
        int low=0;
        int high=n-1;
//        int pivot=arr[high];
        int change=arr[p];
        arr[p]=arr[high];
        arr[high]=change;
        int i=-1;
        int pivot=arr[high];
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the pivot index");
        int pivot=sc.nextInt();
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(lomuto(arr, n, pivot));
    }
}
