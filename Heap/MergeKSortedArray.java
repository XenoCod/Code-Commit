package Codes.Heap;

import java.util.Comparator;

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
    public static void main(String[] args) {

    }
}
