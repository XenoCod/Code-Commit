import java.util.Scanner;

public class PowerOf2 {
    static  boolean powerOf2(int n){
        return ((n!=0) && (n&(n-1))==0);
        //Since all the integers that are power of 2 only have 1 set bit so we unset the only set bit and compare it with 0
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(powerOf2(n));
    }
}