package Codes.DynamicProgramming;
import static Codes.DynamicProgramming.LCS.lcs;
public class SequnecePatternMatching {
    static boolean searchPattern(String a, String b){
        return lcs(a,b)==b.length();
    }
    public static void main(String[] args) {
        String a="SATURDAY";
        String b="DAY";//Pattern to be searched
        System.out.println(searchPattern(a,b));
    }
}
