package Codes.DynamicProgramming;
import static Codes.DynamicProgramming.LCS.lcs;
public class LongestPalidromicSubSequnece {
    static int lps(String a){
        StringBuilder sb= new StringBuilder(a);
        return lcs(a, sb.reverse().toString());
    }
    public static void main(String[] args) {
        String a="SATURDAY";

        System.out.println(lps(a));
    }
}
