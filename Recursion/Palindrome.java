package Codes.Recursion;

import java.util.Scanner;

public class Palindrome {
    static  boolean palindrome(String s, int start, int end){
        if(start>=end){
            return true;
        }
        return ((s.charAt(start)==s.charAt(end))&& palindrome(s,start+1, end-1));

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter String");
       String s=sc.nextLine();
       int start=0;
       int end=s.length();
        System.out.println(palindrome(s,start, end-1));
    }
}
