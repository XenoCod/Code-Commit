import java.util.Scanner;

public class CountSetBits {
    static int countSetBits(int n){
        if(n==1)
            return 1;

        //Brian Kerringham Algo
        int count=0;
        while(n>0){
           n=n&n-1;//Setting the last bit of n to zero
           count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(countSetBits(n));

    }
}