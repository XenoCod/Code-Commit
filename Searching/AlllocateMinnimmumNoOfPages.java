package Codes.Searching;

import java.nio.file.ClosedWatchServiceException;
import java.util.Scanner;

public class AlllocateMinnimmumNoOfPages {
    /*In this question we are given a array which represents a set if pages and length of the array represent the no of books
    We have to divide the pages in such a way that bo od pages read by each student is miniimmum as possible
    Constraints are=
    1. Each student should read a contigious set of pages
    2. Each student has to finish the book completely
    * */
    static  int minPages(int arr[], int n, int k){
        //We are going to use binary search techniqe here
        //Our answer must be lies between the max element of the array and the total sum of the array
        int max=0, sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        int low=max, high=sum;
        int res=0;
        while (low<=high){
            int mid=(low+high)/2;
            if(isFeasible(arr,n,k,mid)){
                res=mid;
                high=mid-1;//moving to the left
            }
            else
                low=mid+1;
        }
        return res;

    }


    static  boolean isFeasible(int arr[], int n, int k, int ans){
        int req=1;//checking the no of student for the range
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }
            else
                sum+=arr[i];
        }
        return (req<=k);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        System.out.println("Enter the no of students");
        int k=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(minPages(arr, n,k));
    }
}
