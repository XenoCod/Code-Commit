package Codes.Recursion;

import java.util.Scanner;

public class NaturalSum {
    static  int naturalSum(int n){
        if(n==0)
            return 0;
        return n+naturalSum(n-1);

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        System.out.println(naturalSum(n));
    }
}
