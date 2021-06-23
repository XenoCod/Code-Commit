package Codes.Searching;

import java.util.Scanner;

public class BinarySearch {
    //Iterative Approach
    static int binarySearch(int arr[], int n, int x){
        int low=0, high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }

    //Recursive approach
    static int bSearch(int arr[], int n, int low, int high, int x){

        int mid=(low+high)/2;
        if(low>high)
            return -1;
        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>x)
            return bSearch(arr, n, low,mid-1, x);
        else
            return bSearch(arr, n, mid+1, high, x);



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
        System.out.println(binarySearch(arr,n,x));
        System.out.println(bSearch(arr, n, 0, n,x));
    }
}
