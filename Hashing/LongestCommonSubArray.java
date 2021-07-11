package Codes.Hashing;

import java.util.HashMap;

public class LongestCommonSubArray {
    static int longestCommon(int arr1[], int arr2[]){
        int temp[]= new int [arr1.length];
        //creating a temp array to store the diff b/w two array and then just find the longest subarrat with 0 sum
        for(int i=0;i< arr1.length;i++)
            temp[i]=arr1[i]-arr2[i];

        int prefix=0;
        int res=0;
        HashMap<Integer, Integer> nums= new HashMap<>();
        for(int i=0;i< temp.length;i++){
            prefix+=temp[i];
            if(prefix==0)
                res=i+1;
            if(!nums.containsKey(prefix))
                nums.put(prefix,i);
           else
               res=Math.max(res, i-(nums.get(prefix)));


        }
        return res;


    }
    public static void main(String[] args) {
        int arr1[]={0,0,1,0};
        int arr2[]={1, 1,1,1 };
        System.out.println(longestCommon(arr1, arr2));
    }
}
