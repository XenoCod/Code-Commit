package Codes.Queue;

import java.net.Inet4Address;
import java.util.ArrayDeque;

public class MaxSubArrayWithSizeK {
    static void printSubArrayMax(int arr[], int k){
        ArrayDeque<Integer> d= new ArrayDeque<>();
        for(int i=0;i<k;i++) {
            while (!d.isEmpty() && arr[i]>=arr[d.peekLast()])
                d.removeLast();
            d.addLast(i);
        }
        for(int i=k;i<arr.length;i++){
            System.out.print(arr[d.peek()]+" ");
            while(!d.isEmpty() && d.peek()<=i-k)
                d.removeFirst();
            while(!d.isEmpty()&& arr[i]>=arr[d.peekLast()])
                d.removeLast();
            d.addLast(i);
        }
        System.out.print(arr[d.peek()]+" ");
    }
    public static void main(String[] args) {
        int arr[]= {10,8,5,12,15,7,6};
        int k=3;
        printSubArrayMax(arr, k);
    }
}
