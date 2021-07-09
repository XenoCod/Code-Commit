package Codes.Hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {
    static boolean zeroSum(int arr[]){
        HashSet<Integer> us= new HashSet<>();
//        Set<Integer> us = new HashSet<Integer>();
        int prefix_sum = 0;
        us.add(0);
        for(int i = 0; i < arr.length; i++)
        {
            prefix_sum += arr[i];
            if(us.contains(prefix_sum))
                return true;

            us.add(prefix_sum);
        }

        return false;

    }
    public static void main(String[] args) {
        int arr[]= {1, 4,13, -3,-10,5};
        System.out.println(zeroSum(arr));

    }
}
