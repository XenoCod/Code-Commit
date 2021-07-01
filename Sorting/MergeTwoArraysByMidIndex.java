package Codes.Sorting;

import java.util.Scanner;

public class MergeTwoArraysByMidIndex {
    static void merge(int arr[], int  low, int mid, int high){
        //Dividing the array in two halves and then merging them
        int n1=  mid-low+1;
        int n2= high-mid;
        int left[]= new int [n1];
        int right[]= new int[n2];
        for(int i=0;i<n1;i++)
            left[i]=arr[low+i];
        for(int i=0;i<n2;i++)
            right[i]=arr[mid+i+1];

        //Normal merge sort algo
        int i=0,j=0,k=low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }
            else{
                arr[k]=right[j];
                j++;
                k++;
            }


        }
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
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
        System.out.println("Enter the left index");
        int left=sc.nextInt();
        System.out.println("Enter the mid");
        int mid=sc.nextInt();
        System.out.println("Enter the right index");
        int right=sc.nextInt();
        merge(arr, left, mid, right);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);

    }
}
