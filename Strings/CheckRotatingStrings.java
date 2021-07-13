package Codes.Strings;

public class CheckRotatingStrings {
    static boolean checkRotate(String str, String target){
        if(str.length()!=target.length())
            return false;
        return ((str+str).contains(target));
    //We can deduce that the target string has to be a substring of the original string addition with itself
    }
    public static void main(String[] args) {
        String s1="ABCD";//Given String
        String s2="CDAB";//target String
        System.out.println(checkRotate(s1,s2));
    }
}
