package Codes.Strings;

public class SubsequencesOfString {
    static boolean subseq(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
int j=0;
        for (int i = 0; i < n1 && j < n2; i++)
            if (s1.charAt(i) == s2.charAt(j))
                j++;
        return j==n2;
    }


    public static void main(String[] args) {
        String s1="ABCD";
        String s2="AD";
        System.out.println(subseq(s1, s2));
    }
}
