package Codes.Hashing;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    //Returns the count of the elements that are present in both the arrays
    static int count(int a[], int b[]){
        HashSet<Integer>nums= new HashSet<>();
        int res=0;
        for(int i:a)
            nums.add(i);
        for(int i:b)
          if(nums.contains(i)) {
              res++;
              nums.remove(i);
          }
        return res;
    }
    public static void main(String[] args) {
        int a[]= {10, 20, 10, 30};
        int b[]={20, 10, 10, 40};
        System.out.println(count(a, b));
    }
}
