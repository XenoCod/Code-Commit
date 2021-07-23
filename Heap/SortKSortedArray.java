package Codes.Heap;

import java.net.Inet4Address;
import java.util.PriorityQueue;

public class SortKSortedArray {
    static void kSort(int arr[], int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int index=0;
        for(int i=0;i<=k;i++)
            pq.add(arr[i]);
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.add(arr[i]);
        }
        while(!pq.isEmpty())
            arr[index++]=pq.poll();
    }

    static void print(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    public static void main(String[] args) {
        int arr[]={9,8,7,18,19,17};
        int k=2;
        kSort(arr,k);
        print(arr);
    }
}
