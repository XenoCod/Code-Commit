package Codes.Recursion;

import java.util.Scanner;

public class RopeCutting {
    static  int ropeCutting(int n, int a, int b, int c){
        if(n<0)
            return -1;
        if(n==0)
            return 0;
        int res=Math.max(ropeCutting(n-a,a,b,c), ropeCutting(n-b,a,b,c));
        res=Math.max(res,ropeCutting(n-c,a,b,c));
        if(res==-1)
            return -1;
        return res+1;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size");
        int n=sc.nextInt();
        System.out.println("Enter values of A B C in sequence");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(ropeCutting(n,a,b,c));
    }
}
