package Codes.Sorting;

import java.util.Scanner;

public class KthSmallestElement {
    static int partition(int arr[], int l, int r){
        int i=l-1;
        int pivot=arr[r];
        for(int j=l;j<=r-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return i+1;
    }
    //Using Lomuto Algo
    static int kth(int arr[], int n, int k){
        int l=0;
        int r=n-1;
        while(l<=r){
            int p=partition(arr, l,r);
            if(p==k-1)
                return p;
            else if(p>k-1)
                r=p-1;
            else
                l=p+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the value for k");
        int k=sc.nextInt();
        System.out.println(arr[kth(arr,n,k)]);

    }
}
