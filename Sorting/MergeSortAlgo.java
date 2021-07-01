package Codes.Sorting;

import java.util.Scanner;

public class MergeSortAlgo {
    static void mergeSort(int arr[], int l, int r){
        if(r>l){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l,mid,r);
        }
    }

    static void merge(int arr[], int l, int m, int h){
//        int n1=mid-low+1;
//        int n2=high-mid;
//        int left[]= new int[n1];
//        int right[]= new int [n2];
//        for(int i=0;i<n1;i++)
//            left[i]=arr[i+low];
//        for(int i=0;i<n2;i++)
//            right[i]=arr[mid+i+1];
//        int i=0, j=0;
//        int k=0;
//        while (i < n1 && j < n2) {
//
//            if(left[i]<=right[j]){
//                arr[k]=left[i];
//                i++;
//                k++;
//            }
//            else{
//                arr[k]=right[j];
//                j++;
//                k++;
//            }
//        }
//        while(i<n1){
//            arr[k]=left[i];
//            i++;
//            k++;
//        }
//        while(j<n2){
//            arr[k]=right[j];
//            k++;
//            j++;
//        }

        int n1=m-l+1, n2=h-m;
        int[] left=new int[n1];
        int[]right=new int[n2];
        for(int i=0;i<n1;i++)
            left[i]=arr[i+l];
        for(int j=0;j<n2;j++)
            right[j]=arr[m+1+j];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the left index");
        int left=sc.nextInt();
        System.out.println("Enter the right index");
        int right=sc.nextInt();
        mergeSort(arr, left,right);
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
    }
}
