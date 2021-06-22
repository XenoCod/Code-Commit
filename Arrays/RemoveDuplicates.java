package Codes.Arrays;

import java.util.Scanner;

public class RemoveDuplicates {

    static  int duplicates(int arr[], int n){
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[count-1]){

                arr[count]=arr[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int count=duplicates(arr,n);
        for(int i=0;i<count;i++)
            System.out.println(arr[i]);
    }
}
