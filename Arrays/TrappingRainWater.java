package Codes.Arrays;

import java.util.Scanner;

public class TrappingRainWater {
    static int rainWater(int arr[], int n){
        int leftMax[]= new int[n];
        int rightMax[]= new int[n];
        int res=0;
        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1];
        //Making a array to store all the max value from Left to right
        for(int i=1;i<n;i++)
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        //Making a array to store all the max value from right to left
        for(int i=n-2;i>=0;i--)
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);

        for(int i=0;i<n;i++){
//            System.out.println(res);
            res+=(Math.min(leftMax[i], rightMax[i])-arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter size");
//        int n=sc.nextInt();
//        int arr[]= new int[n];
//        System.out.println("Enter elements");
//        for(int i=0;i<n;i++)
//            arr[i]=sc.nextInt();
        int arr[]={1,2,3,4,5}; int n=arr.length;
        System.out.println(rainWater(arr,n));
    }
}
