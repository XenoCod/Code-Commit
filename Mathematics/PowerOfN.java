import java.util.Scanner;

public class PowerOfN {
    static int powerOfN(int x, int n){
        int res=1;
        while(n>0){
            if((n&1)==1){
                res*=x;
            }
            x*=x;
            n=n>>1;

        }
        return res;
        
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(powerOfN(x,n));

    }
}
