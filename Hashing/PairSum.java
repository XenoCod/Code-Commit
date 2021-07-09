package Codes.Hashing;

import java.util.HashSet;

public class PairSum {
    static boolean isPair(int arr[], int sum){
        HashSet<Integer> nums= new HashSet<>();
        for(int i:arr) {
            if (nums.contains(sum - i))
                return true;
            else
                nums.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]= {8, 3, 4, 2, 5};
        int sum=11;
        System.out.println(isPair(arr, sum));
    }
}
