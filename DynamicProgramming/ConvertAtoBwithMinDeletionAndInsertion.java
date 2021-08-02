package Codes.DynamicProgramming;
import static Codes.DynamicProgramming.LCS.lcs;

public class ConvertAtoBwithMinDeletionAndInsertion {
    static void convert(String a, String b){
        int m=a.length(), n=b.length();
        System.out.println("Minimmum deletion to convert A to B=> "+ (m-lcs(a,b)));
        System.out.println("Minnimmum addition to convert to A to B=> "+(n-lcs(a,b)));
    }
    public static void main(String[] args) {
        String a="SATURDAY", b="SUNDAY";
        convert(a,b);
    }
}
