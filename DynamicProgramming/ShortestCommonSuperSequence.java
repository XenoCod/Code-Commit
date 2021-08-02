package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.LCS.lcs;

public class ShortestCommonSuperSequence {
    static int shortestSubsequnece(String a, String b){
        return a.length()+b.length()-lcs(a,b);
    }
    public static void main(String[] args) {
        String a="SUNDAY", b="SATURDAY";
        System.out.println(shortestSubsequnece(a,b));
    }
}
