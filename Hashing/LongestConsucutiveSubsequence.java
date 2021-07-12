package Codes.Hashing;

import java.util.HashSet;

public class LongestConsucutiveSubsequence {
    static int subsequnence(int arr[]){
        HashSet<Integer>nums= new HashSet<>();
        int res=0;
        for(int i:arr)
            nums.add(i);
        for(int i:nums){
            if(!nums.contains(i-1)){
                int curr=1;
                while(nums.contains(i+curr))
                    curr++;
                res=Math.max(res,curr);
            }


        }
        return res;
    }
    public static void main(String[] args) {
//        int arr[]= {1,3,4,3,3,2,9,10};
//        int arr[]= {8, 20, 7, 30};
        int arr[]= {10, 20, 30};
        System.out.println(subsequnence(arr));
    }
}
