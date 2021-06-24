package Codes.Searching;

import java.util.Scanner;

public class CountOccurence {
    //Counting the first Occurence Index
    static int firstOcc(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid= (low+high)/2;
            if(arr[mid]>x)
                high=mid+1;
            else if(arr[mid]<x)
                low=mid+1;
            else
                if(mid==0 ||arr[mid]!=arr[mid-1])
                    return mid;
                else
                    high=mid-1;

        }
        return -1;

    }

    //Counting the last occurence Index
    static int lastOcc(int arr[], int n, int x) {
        int low=0;
        int high=n-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid]>x)
                high=mid-1;
            else if(arr[mid]<x)
                low=mid+1;
            else
                if (mid!=n-1 ||arr[mid]!=arr[mid+1])
                    return mid;
                else
                    low=mid+1;
        }
        return -1;

    }


    static int countOccurence(int arr[], int n, int x){

        int first=firstOcc(arr, n,x);
        //O(log n) Time complexity
        //Means element is not present in array
        if(first==-1)
            return 0;
        else
            return (lastOcc(arr,n,x)-first+1);
        //If the elemeent has a first Index then it would definately has last occurenece
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
        System.out.println(countOccurence(arr, n,x));
    }
}
