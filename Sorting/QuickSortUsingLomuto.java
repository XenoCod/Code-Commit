package Codes.Sorting;

import java.util.Scanner;

public class QuickSortUsingLomuto {
    static int partition(int arr[], int l, int h){
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }
    static void qSort(int arr[], int l, int h){
     
        if(l<h) {
            int pivot = partition(arr,l,h );
            qSort(arr,l,pivot-1);
            qSort(arr,pivot+1,h);
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
        qSort(arr, 0, n-1);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
