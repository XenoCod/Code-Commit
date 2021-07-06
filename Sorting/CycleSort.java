package Codes.Sorting;

import java.util.Scanner;

public class CycleSort {

//This sorting algo mostly used to sorting the array with minnmum swaps
    static void cycleSort(int arr[], int n){
        for(int start=0;start<n-1;start++){
            int item=arr[start];
            int pos=start;
            for(int i=start+1;i<n;i++)
                if(arr[i]<item)
                    pos++;
            int temp=arr[pos];
            arr[pos]=item;
            item=temp;
            while(start!=pos){
                pos=start;
                for(int i=start+1;i<n;i++)
                    if(arr[i]<item)
                        pos++;

                    temp=arr[pos];
                    arr[pos]=item;
                    item=temp;
            }



        }

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        cycleSort(arr,n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i])  ;
    }
}
