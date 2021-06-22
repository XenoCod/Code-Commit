package Codes.Arrays;

import java.util.Scanner;

public class MajorityElementinArrayInLinearTime {
    static int majority(int arr[], int n){
        //Using Moore Voting Algo
        int count=1, res=0;
        for(int i=1;i<n;i++) {
            if (arr[res] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                res = arr[i];
                count=1;
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(arr[res]==arr[i])
                count++;
        }
        return count>=n/2?res:-1;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(majority(arr,n));
    }
}
