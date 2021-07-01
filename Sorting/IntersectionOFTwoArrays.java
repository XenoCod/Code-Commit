package Codes.Sorting;

import java.util.Scanner;

public class IntersectionOFTwoArrays {
    static  void intersection(int arr1[], int arr2[], int m, int n){
        int i=0,j=0;
        while(i<m && j<n){
            if(i>0 && arr1[i]==arr2[i-1]){
                i++;
                continue;
            }
            if(arr1[i]<arr2[j])
                i++;
            else if(arr1[i]>arr2[j])
                j++;
            else {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
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
        for(int i=0;i<m;i++)
            arr1[i]=sc.nextInt();
        System.out.println("Enter elements for array 2");
        for(int i=0;i<n;i++)
            arr2[i]=sc.nextInt();
        intersection(arr1,arr2,m,n);
    }
}
