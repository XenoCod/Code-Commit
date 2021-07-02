package Codes.Sorting;

import java.util.Scanner;

public class HoareParition {
    static int hoare(int arr[], int n){
        int low=0;
        int high=n-1;
        int i=low-1;
        int j=high+1;

        //Here we always assume that the first element is the pivot index if the pivot is explcitly specified we swap the first element with pivot element
        int pivot=arr[low];
        while(true){
            do {
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
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(hoare(arr, n));
    }
}
