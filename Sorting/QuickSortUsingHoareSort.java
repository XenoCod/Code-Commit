package Codes.Sorting;

import java.util.Scanner;

public class QuickSortUsingHoareSort {
    static int partition(int arr[], int l, int h){
        int pivot=arr[l];
        int i=l-1;
        int j=h+1;
        while(true){
            do{
                i++;
            }while (arr[i]<pivot);

            do{
                j--;
            }while (arr[j]>pivot);

            if(i>=j)
                return j;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

        }

    }
    static void qSort(int arr[], int l, int h){
        if(l<h){
            int pivot=partition(arr, l, h);
            qSort(arr, l,pivot);
            qSort(arr, pivot+1, h);
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
