package Codes.Strings;

public class PalindromeCheck {
    static boolean isPal(String s){
        int begin=0;
        int end=s.length()-1;
        while(begin<end){
            if(s.charAt(begin)!=s.charAt(end))
                return false;
            begin++;
            end--;

        }
        return true;
    }
    public static void main(String[] args) {
        String s="ABBCBBA";
        System.out.println(isPal(s));
    }
}
