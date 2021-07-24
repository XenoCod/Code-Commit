package Codes.Heap;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
    int value, position, valIndex;
    Triplet(int v, int p, int vI){
        value=v;
        position=p;
        valIndex=vI;
    }
    public int compareTo(Triplet t){
        if(value<=t.value)
            return -1;
        else
            return 1;
    }
}



public class MergeKSortedArray {

    static ArrayList<Integer> mergeArr(ArrayList<ArrayList<Integer>> arr){
        PriorityQueue<Triplet> pq= new PriorityQueue<>();
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i<arr.size();i++)
            pq.add(new Triplet(arr.get(i).get(0), i,0));
        while (!pq.isEmpty()){
            Triplet curr=pq.poll();
            res.add(curr.value);
            int arrPos=curr.position;
            int valPos=curr.valIndex;
            if(valPos+1<arr.get(arrPos).size())
                pq.add(new Triplet(arr.get(arrPos).get(valPos+1),arrPos,valPos+1));

        }
        return res;



    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > arr=new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        ArrayList<Integer> res=mergeArr(arr);
        System.out.println(res);

    }
}
