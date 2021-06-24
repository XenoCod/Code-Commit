package Codes.Searching;

import java.util.Scanner;

public class FindTripletSumInArray {
    static boolean pairSum(int arr[], int left, int right, int x){
        //Using two pointer approach( Only works when Array is sorted)

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

    static boolean tripletsSum(int arr[], int n, int x){
        for(int i=0;i<n;i++){
        if(pairSum(arr, i+1, n-1, x-arr[i]))
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        System.out.println("Enter the element to be searched");
        int x=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(tripletsSum(arr,n,x));
    }
}
