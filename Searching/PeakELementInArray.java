package Codes.Searching;

import java.util.Scanner;

public class PeakELementInArray {
    //Peak elemenet is the element which is greater
    // than both of its neighbour
    static  int peak(int arr[], int n){
        int low =0, high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            /*We are using the fact that when we compared the
            mid-1 > mid the peak element is defiantely present
            in the left side so we search on the side of array
            OR
            mid+1> mid the peak element is always present on the
            right side so we search on right side of array
            */
            if((mid==0 || arr[mid]>=arr[mid-1]) &&(mid==n-1 || arr[mid]>=arr[mid+1]))
                return arr[mid];
            else
                if (arr[mid-1]>arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(peak(arr,n));
    }
}
