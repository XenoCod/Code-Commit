package Mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class SeiveOfEratosthens {

    static void seive(int n){
        boolean arr[]= new boolean[n+1];
        Arrays.fill(arr, true);
        for(int i=2;i<=n;i++){
            if(arr[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
       seive(n);

    }
}
