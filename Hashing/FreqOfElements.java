package Codes.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FreqOfElements {
    static void freq(int arr[]){
        HashMap<Integer, Integer> hmap= new HashMap<>();
        for(int i:arr)
            hmap.put(i,hmap.getOrDefault(i,0 )+1);
        for(Map.Entry<Integer, Integer> e:hmap.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
    public static void main(String[] args) {
        int arr[]={10, 12, 10, 15, 10, 20, 12, 12};
        freq(arr);

    }
}
