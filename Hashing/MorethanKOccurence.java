package Codes.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MorethanKOccurence {
    static void moreThanK(int arr[], int k){

//        O(n) solution

        int n=arr.length;
        int limit=n/k;
        HashMap<Integer, Integer> nums= new HashMap<>();
        for(int i:arr)
            nums.put(i, nums.getOrDefault(i, 0)+1);
        for(Map.Entry<Integer, Integer>it:nums.entrySet()){
            if(it.getValue()>limit)
                System.out.print(it.getKey()+" ");
        }


////        O(n*k) solution
//        int n=arr.length;
//        int limit=n/k;
//        HashMap<Integer, Integer> nums= new HashMap<>();
//        for(int i:arr){
//            if(nums.containsKey(i))
//                nums.put(i, nums.get(i)+1);
//            else if (nums.size()<k-1)
//                nums.put(i, 1);
//            else {
//                for(Map.Entry<Integer, Integer>it:nums.entrySet()){
//                    nums.put(it.getKey(), it.getValue()-1);
//                    if(it.getValue()==0)
//                        nums.remove(it.getKey());
//                }
//            }
//        }
//        for(Map.Entry<Integer, Integer>it:nums.entrySet()){
//            if(it.getValue()>limit)
//                System.out.print(it.getKey()+ " ");
//        }
//        System.out.println(nums);
    }


    public static void main(String[] args) {
//        int arr[]={30, 10, 20, 20, 10, 20, 30, 30};
//        int k=4;
        int arr[]={30, 10, 20, 30, 30, 40, 30, 40, 30};
        int k=2;
        moreThanK(arr, k);
    }
}
