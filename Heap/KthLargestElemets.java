package Codes.Heap;

import java.net.Inet4Address;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElemets {
    static void kthLargest(int arr[], int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(arr[i]);
        for(int i=k;i<arr.length;i++)
            if(pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        for(int i:pq)
            System.out.print(i+" ");

    }
    public static void main(String[] args) {
        int arr[]={5,15,10,20,8};
        int k=4;
        kthLargest(arr,k);
    }
}
