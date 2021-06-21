package Mathematics;

import java.util.Scanner;

public class Palindrome {

    static boolean palindrome(int n) {
        int temp = n;
        int rev = 0;
        while (temp > 0) {
            rev = (rev * 10) + (temp % 10);
            temp /= 10;
        }
        return (n == rev);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(palindrome(n));

    }

}
