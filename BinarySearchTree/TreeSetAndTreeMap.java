package Codes.BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetAndTreeMap {
    public static void main(String[] args) {
        TreeSet<Integer> t= new TreeSet<>();
        t.add(10);
        t.add(20);
        t.add(30);
        System.out.println("TREE SET");
        System.out.println(t);
        System.out.println(t.contains(20));
        System.out.println(t.contains(40));
        System.out.println(t.floor(10));
        System.out.println(t.ceiling(10));
        System.out.println(t.lower(10));
        System.out.println(t.higher(10));
        for(Integer s:t)
            System.out.println(s);
        System.out.println("TREEMAP");


        TreeMap<Integer, String> tm= new TreeMap<>();
        tm.put(10, "This");
        tm.put(20, "is");
        tm.put(30, "A");
        tm.put(40, "Tree");
        tm.put(50, "Map");
        System.out.println(tm);
        for(Map.Entry<Integer, String> i:tm.entrySet())
            System.out.println(i.getKey()+" "+i.getValue());
        System.out.println(tm.lowerKey(30));
        System.out.println(tm.higherKey(30));
        System.out.println(tm.floorKey(30));
        System.out.println(tm.ceilingKey(30));

    }
}
