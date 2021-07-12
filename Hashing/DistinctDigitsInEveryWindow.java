package Codes.Hashing;

import java.util.HashMap;

public class DistinctDigitsInEveryWindow {
    static void distinctCount(int arr[], int k){
        HashMap<Integer, Integer> nums= new HashMap<>();
        for(int i=0;i<k;i++)
            nums.put(arr[i], nums.getOrDefault(arr[i],0)+1);

        System.out.print(nums.size()+" ");
        for(int i=k;i<arr.length;i++){
            nums.put(arr[i-k], nums.get(arr[i-k])-1);
            if(nums.get(arr[i-k])==0)
                nums.remove((arr[i-k]));
            nums.put(arr[i], nums.getOrDefault(arr[i],0)+1);
            System.out.print(nums.size()+" ");
        }

    }
    public static void main(String[] args) {
        int arr[]={10, 20, 10, 10, 30, 40};
        int window=4;
        distinctCount(arr, window);
    }
}
