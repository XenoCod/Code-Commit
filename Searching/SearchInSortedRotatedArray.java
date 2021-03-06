package Codes.Searching;

import java.util.Scanner;

public class SearchInSortedRotatedArray {
    static int sortedRotated(int arr[], int n, int x){
        int low=0;
        int high=n-1;
        //We know that atleast one of the element in this type of
        // array will always be sorted and if the mid is smaller
        // than the first element in the array then we definalty
        // know that the subarray is sorted so we only
        // check whether the searched element lies in the
        // given range and if not then we check to the
        // other side of the array
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;
            else{
                if(arr[low]<arr[mid]){
                    if(x>=arr[low] && x<arr[mid])
                        high=mid-1;
                    else
                        low=mid+1;

                }
                else
                    if(x>arr[mid] && x<=arr[high])
                        low=mid+1;
                    else
                        high=mid-1;


            }

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
        System.out.println(sortedRotated(arr,n,x));
    }
}
