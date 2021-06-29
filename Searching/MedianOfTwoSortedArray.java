package Codes.Searching;

import java.util.ArrayList;
import java.util.Scanner;

public class MedianOfTwoSortedArray {
    static double median(int arr1[],int arr2[], int n1, int n2){
        //We always consider the first array to be smaller one
        /* The basic idea is to make two sets of each array with the mid being the midpoint of the array such that there left side of the mid contains vakues less than mid and right side contains the values more than the mid
        then we compare the mid of the both the array if the last element (max element of the set) left set of array2 is greater the mid of the array 1 then we got our both medians so we return the max element between both of them
        else we binary search for the element by either shifting it towords the left or right
        * */
        int begin=0, end=n1;
        while (begin <= end) {

            int i1=(begin+end)/2;//mid point of 1st array
            int i2=((n1+n2)/2)-1;//midpoint of 2nd array
            int min1=(i1==n1)?(Integer.MAX_VALUE):arr1[i1];//min element of the 1st array i,e the mid point element
            int max1=(i1==0)?Integer.MIN_VALUE:arr1[i1-1];//element to the left of the midpoint for comparison
            int min2=(i2==n2)?Integer.MAX_VALUE:arr2[i2];//midpoint element of the 2nd array
            int max2=(i2==0)?Integer.MIN_VALUE:arr2[i2-1];//left most element of arr2 used for comparison

            if(max1<=min2 && max2<=min1)
                if((n1+n2)%2==0)
                    return (double) (Math.max(max1,max2)+(Math.min(min1,min2)))/2;
                else
                    return (double) Math.max(max1,max2);

            else if(max1>min2)
                end=i1-1;
            else
                begin=i1+1;

        }
        return 0;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr1[]= new int[n];
        System.out.println("Enter elements for 1st array");
        for(int i=0;i<n;i++)
            arr1[i]=sc.nextInt();
        System.out.println("Enter the size of 2nd array");
        int n2= sc.nextInt();
        int arr2[]= new int[n2];
        System.out.println("Enter elements for 2nd array");
        for(int i=0;i<n2;i++)
            arr2[i]=sc.nextInt();
        System.out.println(median(arr1, arr2, n,n2));

    }
}
