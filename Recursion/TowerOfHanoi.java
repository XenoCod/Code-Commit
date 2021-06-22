package Codes.Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    static void towerOfHanoi(int n, char a , char b, char c){
        if(n==1){
            System.out.println("Move disc 1 from "+ a+ " to "+c);
            return ;
        }
        towerOfHanoi(n-1, a,c,b);
        System.out.println("Move disc "+n+ " from "+a+" to "+c);
        towerOfHanoi(n-1, b,a,c);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        char a='A';
        char b='B';
        char c='C';
        towerOfHanoi(n,a,b,c);
    }
}
