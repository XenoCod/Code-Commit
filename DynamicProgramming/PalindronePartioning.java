package Codes.DynamicProgramming;

public class PalindronePartioning {
    static boolean isPalindrome(String a, int start, int end){
//
        while(start<end){
            if(a.charAt(start)!=a.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static int mcm(String a, int i, int j){
        if(i>=j)
            return 0;
        if(isPalindrome(a,i, j))
            return 0;
        int res=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int minCost=mcm(a, i, k)+mcm(a, k+1, j)+1;
            res=Math.min(res, minCost);
        }
        return res;
    }

    public static void main(String[] args) {
        String a="abcba";
        a="ababbbabbababa";
        System.out.println(mcm(a, 0, a.length()-1));
    }
}
