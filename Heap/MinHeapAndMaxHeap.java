package Codes.Heap;

import Codes.Stack.PreviouGreaterElement;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinHeapAndMaxHeap {
    public static void main(String[] args) {
        //to create a MinHeap build a PriorityQueue
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(5);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
        //To use a MaxHeap initiate PrirityQueue with Collection.ReverseOrder
        PriorityQueue<Integer> pq1= new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(5);
        pq1.add(15);
        pq1.add(25);
        pq1.add(35);
        System.out.println(pq1);
        pq1.poll();
        System.out.println(pq1);
    }
}
