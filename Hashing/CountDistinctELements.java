package Codes.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctELements {
    static int count(int arr[]){
        HashSet<Integer> nums= new HashSet<>();
        for(int i:arr)
            nums.add(i);
        return nums.size();


    }
    public static void main(String[] args) {
            int arr[]={15,12,13,12,13,18};
        System.out.println(count(arr));
    }
}
