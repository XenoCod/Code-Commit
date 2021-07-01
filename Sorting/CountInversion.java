package Codes.Sorting;

import java.util.Scanner;

public class CountInversion {
    static  int countAndMerge(int arr[], int l, int mid, int r){

        int n1=mid-l+1;
        int n2=r-mid;
        int left[]= new int [n1];
        int right[]= new int[n2];
        for(int i=0;i<n1;i++)
            left[i]=arr[i+l];

        for(int i=0;i<n2;i++)
            right[i]=arr[mid+1+i];

        int i=0, j=0, k=l;
        int res=0;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                k++;
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
                k++;
                res=res+(n1-i);
            }
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];
        return res;
    }
    static int inversion(int arr[], int n, int l, int r){
        int mid =(l+r)/2;
        int res=0;
        if(r>l) {
            res += inversion(arr, n, l, mid);
            res += inversion(arr, n, mid + 1, r);
            res += countAndMerge(arr, l, mid, r);
        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int m=sc.nextInt();
        int arr[]= new int[m];
        System.out.println("Enter elements for array");
        for(int i=0;i<m;i++)
            arr[i]=sc.nextInt();
        System.out.println(inversion(arr, m,0,m-1 ));
    }
}
