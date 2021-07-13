package Codes.Strings;

public class LeftMostRepeatingChar {
    static char leftMost(String s){
        boolean visited[]= new boolean[256];
        char res=' ';
        for(int i=s.length()-1;i>=0;i--){
            if(visited[s.charAt(i)])
                res=s.charAt(i);
            else
                visited[s.charAt(i)]=true;
        }
        return res;
    }
    public static void main(String[] args) {
        String s="abbccd";
//        String s="geeksforgeeks";
        System.out.println(leftMost(s));

    }
}
