package Codes.Heap;

import java.net.Inet4Address;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElemets {
    static void kthLargest(int arr[], int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++)
            pq.add(arr[i]);
        int i=0;
        while(i<k){
            System.out.print(pq.poll()+" ");
            i++;
        }


    }
    public static void main(String[] args) {
        int arr[]={5,15,10,20,8};
        int k=3;
        kthLargest(arr,k);
    }
}
