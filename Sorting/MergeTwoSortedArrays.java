package Codes.Sorting;

import java.util.Scanner;

public class MergeTwoSortedArrays {
    static void merge(int arr1[], int arr2[], int m, int n){
        int i=0, j=0;
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }
            else{
                System.out.println(arr2[i]);
                j++;
            }
        }
        while(i<m){
            System.out.println(arr1[i]);
            i++;
        }
        while(j<n) {
            System.out.println(arr2[j]);
            j++;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int m=sc.nextInt();
        int arr1[]= new int[m];
        System.out.println("Enter size of 2nd array");
        int n=sc.nextInt();
        int arr2[]= new int[n];
        System.out.println("Enter elements for array 1");
        for(int i=0;i<n;i++)
            arr1[i]=sc.nextInt();
        System.out.println("Enter elements for array 2");
        for(int i=0;i<n;i++)
            arr2[i]=sc.nextInt();
        merge(arr1,arr2,m,n);
    }
}
