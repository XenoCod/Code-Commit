package Codes.Arrays;

import java.util.Scanner;

public class MaxConscutive1s {
    static int max1s(int arr[], int n){
        int count=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                count=0;
            else {
                count++;
                res=Math.max(res,count);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(max1s(arr,n));
    }
}
