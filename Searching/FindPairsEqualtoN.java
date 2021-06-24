package Codes.Searching;

import java.util.Scanner;

public class FindPairsEqualtoN {
    static boolean pairSum(int arr[], int n, int x){
        //Using two pointer approach( Only works when Array is sorted)
         int left=0;
         int right=n-1;
         while(left<right){
             int sum=arr[left]+arr[right];
             if(sum==x)
                 return true;
             else if(sum>x)
                 right--;
             else
                 left++;
         }
         return false;
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
        System.out.println(pairSum(arr,n,x));
    }
}
