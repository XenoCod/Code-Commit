package Codes.DynamicProgramming;

import static Codes.DynamicProgramming.LongestPalidromicSubSequnece.lps;

public class MinDeletionToMakeStringPalidromic {
    static int makePalidrome(String a){
        return a.length()-lps(a);
    }
    //Note=. Min deletion in string to make Palindrone == Min insertion in string to make palindrone
    public static void main(String[] args) {
        String a="agbcba";
        System.out.println(makePalidrome(a));
    }
}
