package Codes.Strings;

import java.util.Arrays;

public class LeftMostNonRepeating {
    static char nonRepating(String s){
        int res=Integer.MAX_VALUE;
        int temp[]= new int [256];
        Arrays.fill(temp, -1);
        int i=0;
        for(char c:s.toCharArray()){
            if(temp[c]==-1){
               temp[c]=i;
            }
            else
                temp[c]=-2;
            i++;
        }
        for(int j:temp){
            if(j>=0)
                res=Math.min(res,j);
        }
        return res==Integer.MAX_VALUE?'~':s.charAt(res);
    }
    public static void main(String[] args) {
//        String s="geeksforgeeks";
//        String s="abcabc";
        String s="apple";

        System.out.println(nonRepating(s));

    }
}
