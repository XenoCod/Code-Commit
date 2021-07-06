package Codes.Sorting;

import java.util.Scanner;

public class CycleSort {

//This sorting algo mostly used to sorting the array with minnmum swaps
    static void cycleSort(int arr[], int n){
        for(int cs=0;cs<n-1;cs++){
            int item=arr[cs];
            int pos=cs;
            for(int i=cs+1;i<n;i++)
                if(arr[i]<item)
                    pos++;
            //swap(item,arr[pos])

            int temp=item;
            item=arr[pos];
            arr[pos]=temp;

            while(pos!=cs){
                pos=cs;
                for(int i=cs+1;i<n;i++)
                    if(arr[i]<item)
                        pos++;

                //swap(item,arr[pos])
                temp=item;
                item=arr[pos];
                arr[pos]=temp;
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of 1st array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter the elememts");
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        cycleSort(arr,n);
        for(int i=0;i<n;i++)
            System.out.println(arr[i])  ;
    }
}
