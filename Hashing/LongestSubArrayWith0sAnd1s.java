package Codes.Hashing;

import java.net.Inet4Address;
import java.util.HashMap;

public class LongestSubArrayWith0sAnd1s {
    static int longestZeroArray(int arr[]){
        HashMap<Integer, Integer> nums= new HashMap<>();
        //Here we simply replacing all the zeros with -1 and the count the longest subArray with sum=0
        for(int i=0;i<arr.length;i++)
            if(arr[i]==0)
                arr[i]=-1;


        int prefixSum=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==0)
                res=i+1;

            if(!nums.containsKey(prefixSum))
                nums.put(prefixSum, i);

            else
                res=Math.max(res, i-(nums.get(prefixSum)));



        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,  1,1, 0,1, 0};
        System.out.println(longestZeroArray(arr));
    }
}
