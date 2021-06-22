package Codes.Recursion;

import java.util.Scanner;

public class SubsetsOfString {
    static  void subsets(String s, int i, String curr){
        if(i==s.length()){
            System.out.print(curr+ " ");
            return;
        }
        subsets(s, i+1, curr);
        subsets(s, i+1,curr+s.charAt(i));



    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the string");
        String s=sc.nextLine();
        int i=0;
        String curr="";
        subsets(s, i, curr);
    }
}
