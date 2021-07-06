package Codes.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingMaxGuests {
    static int maxGuests(int arrival[],int departure[], int n){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i=1, j=0, res=1, count=1;
        //count
        while(i<n && j<n){
            if(arrival[i]<=departure[j]){
                count++;
                i++;
            }
            else{
                j--;
                count--;
            }
            res=Math.max(res,count);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of n");
        int n=sc.nextInt();
        int arrival[]= new int[n];

        int departures[]= new int[n];
        System.out.println("Enter the arrival times");
        for(int i=0;i<n;i++)
            arrival[i]=sc.nextInt();
        System.out.println("Enter size of departures times");
        for(int i=0;i<n;i++)
            departures[i]=sc.nextInt();
        System.out.println(maxGuests(arrival, departures, n));
    }
}
