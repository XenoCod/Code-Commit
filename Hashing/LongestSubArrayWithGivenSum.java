package Codes.Hashing;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
    static int longestSubArray(int arr[], int sum){
        HashMap<Integer, Integer> nums= new HashMap<>();
        int prefixSum=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==sum)
                res=i+1;
            if(!nums.containsKey(prefixSum))
                nums.put(prefixSum, i);
            if(nums.containsKey(prefixSum-sum))
                res=Math.max(res, i-nums.get(prefixSum-sum));
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]= {8, 3, 1, 5, -6 , 6, 2, 2};
        int sum=4;
        System.out.println(longestSubArray(arr, sum));
    }
}
