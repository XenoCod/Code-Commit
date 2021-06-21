package Mathematics;

import java.util.Scanner;

public class TrailingZeros {
    static  int trailing(int n){
        int res=0;
        for(int i=5;i<n;i*=5){
            res+=(n/i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(trailing(n));
        //Just counting the no of 5s in prime factorization of n
    }
}
