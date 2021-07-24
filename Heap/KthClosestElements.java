package Codes.Heap;

import java.lang.annotation.Inherited;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int key;
    int value;
    Pair(int k, int v){
        this.key=k;
        this.value=v;
    }
    int getKey(){
        return key;
    }
    void setKey(int k){
        this.key=k;
    }
    int getValue(){
        return value;
    }
    void setValue(int v){
        this.value=v;
    }

}



public class KthClosestElements {
    static void kthClosest(int arr[], int x, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>()
                {
                    @Override
                    public int compare(Pair p1, Pair p2)
                    {
                        return p2.getValue().compareTo(
                              p1.getValue());
                    }
                });

        for(int i = 0; i < k; i++)
        {
            pq.offer(new Pair(arr[i],
                    Math.abs(arr[i] - x)));
        }

        for(int i = k; i < arr.length; i++)
        {
            int diff = Math.abs(arr[i] - x);

            if(pq.peek().getValue()>diff) {
                pq.poll();
                pq.offer(new Pair(arr[i], diff));
            }
        }

        while(!pq.isEmpty())
        {
            System.out.print(pq.poll().getKey() + " ");
        }


    }
    public static void main(String[] args) {
        int arr[]={40,41,2,4,12,5,6,113,77};
        int num=43;
        int k=3;
       kthClosest(arr,num ,k );
    }
}
