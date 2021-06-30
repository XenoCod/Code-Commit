package Codes.Sorting;

import java.util.Scanner;

public class InsertionSort {
    static  void insertionSort(int arr[], int n){
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            //moving allt the element to the right side to make space for the new key element
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
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
        insertionSort(arr,n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
