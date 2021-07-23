package Codes.Heap;

import java.util.PriorityQueue;

public class BuyMaxItemsWithGivenSum {
    static int findMax(int arr[], int sum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, n = arr.length;
        for (int i = 0; i < n; i++)
            pq.add(arr[i]);
        for (int i = 0; i < n; i++) {
            if (pq.peek() <= sum) {
                sum -= pq.poll();
                res++;
            }
            else
                break;
        }
        return res;

    }
    public static void main(String[] args) {
        int arr[]={1,12,5,111,200};
        int sum=10;
        System.out.println(findMax(arr, sum));

    }
}


