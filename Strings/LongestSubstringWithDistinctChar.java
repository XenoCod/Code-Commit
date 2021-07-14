package Codes.Strings;

import java.util.HashSet;

public class LongestSubstringWithDistinctChar {
    static int longestSubstring(String s){
        HashSet<Character> nums= new HashSet<>();
        int res=0;
        for(int i=0;i<s.length();i++){
            if(!nums.contains(s.charAt(i)))
                nums.add(s.charAt(i));
            else{
                res=Math.max(res, nums.size());

                nums.clear();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s="abcdabc";
        System.out.println(longestSubstring(s));

    }
}
