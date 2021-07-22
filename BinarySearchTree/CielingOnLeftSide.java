package Codes.BinarySearchTree;

import java.util.Iterator;
import java.util.TreeSet;

public class CielingOnLeftSide {
    static void getCieling(int arr[]){
        TreeSet<Integer> nums= new TreeSet<>();
        nums.add(arr[0]);
        System.out.print("-1 ");
        for(int i=1;i<arr.length;i++){
            if(nums.ceiling(arr[i])!=null)
                System.out.print(nums.ceiling(arr[i])+" ");
            else
                System.out.print("-1"+" ");
            nums.add(arr[i]);
        }

    }
    static int getSmallest(int arr[], int k){
       int j=0;
       int res=0;
        TreeSet<Integer> nums= new TreeSet<>();
        for(int i=0;i<arr.length;i++)
            nums.add(arr[i]);
        Iterator it= nums.iterator();
        while(it.hasNext() && j<k){
            res=(int) it.next();
            j++;

        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={2, 8, 30, 15, 25, 12};
        getCieling(arr);
        System.out.println(getSmallest(arr, 3));

    }
}
