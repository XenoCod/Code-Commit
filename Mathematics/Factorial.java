package Mathematics;

import java.util.Scanner;

public class Factorial {
    //Recursive approach
    static int recursiveFact(int n){
        if(n==0){
            return 1;
        }
        return n*recursiveFact(n-1);
    }

    //Iterative approach
    static int iterativeFac(int n){
        int fact=1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int res1= recursiveFact(n);
        int res2=iterativeFac(n);
        System.out.println(res1+ " "+ res2);
        //Iterative approach is preffered because recursive requires more auxilarry space and more function call heads.

    }
}
