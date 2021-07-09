package Codes.Hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {
    static boolean find(int arr[], int k){
        HashSet<Integer> nums= new HashSet<>();
        int prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(nums.contains(prefixSum-k))
                return true;
            nums.add(prefixSum);

        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={5, 8, 6 , 13, 3, -1};
        int sum=22;
        System.out.println(find(arr, sum));
    }
}
