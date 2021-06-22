package Codes.Arrays;

import java.util.Scanner;

public class MaxCircularSubArraySum {
    static int normalSum(int arr[], int n){
        int sum=arr[0];
        int res=0;
        for(int i=1;i<n;i++){
            sum=Math.max(sum+arr[i], arr[i]);
            res=Math.max(res,sum);
        }
        return res;

    }
    static int cirularSum(int arr[], int n){
        int linearSum=normalSum(arr,n);
        int circleSum=0;
        /*Max cirular sum of the array would always be the Max value of
        * Max Linear SubArray sum
        * Max Circular SubArray sum
        So here we calculate the Normal SubArray sum using Kadane Algo
        and then to caculate the Circular subArray sum
        we make all the elements of the array as negetive and
        Add the total sum to the negetive sum
        * Then in the final step we return the max value among the Normal SubArray sum and Ciruclar subArray sum calculated*/
        for(int i=0;i<n;i++){
            circleSum+=arr[i];
            arr[i]=-arr[i];
        }
        circleSum+=normalSum(arr,n);
        return Math.max(linearSum, circleSum);


    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(cirularSum(arr, n));
    }
}
