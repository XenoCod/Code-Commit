package Mathematics;

import java.util.Scanner;

public class AllDIvisors {
    static void allDivisors(int n){
        int i;
        for(i=1;i*i<n;i++){
            if(n%i==0) {
                System.out.print(i + " ");
            }
        }
        for(;i>=1;i--){
            if(n%i==0){
                System.out.print(n/i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        allDivisors(n);
        //Printing all the divisors of the number in a sorted form

    }
}
