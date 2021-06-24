package Codes.Searching;

import java.util.Scanner;

public class LastOccurenceIndexInArray {
    static  int lastIndex(int arr[], int n, int x){
        int low =0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x)
                high=mid-1;
            else if(arr[mid]<x)
                low=mid+1;
            else
                if(mid!=n-1 ||arr[mid]!=arr[mid+1])
                    return mid;
                else
                    low=mid+1;

        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        System.out.println("Enter element to be searched");
        int x=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(lastIndex(arr, n,x));
    }
}
