import java.util.Scanner;

public class CheckKthBit {
    static boolean checkBit(int n, int k){
        if(n<=1)
            return false;
        if(((n>>(k-1))&1)==1)
            return true;
        else
            return  false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(checkBit(n,k));

    }
}
