package Codes.Searching;

import java.awt.*;
import java.util.Scanner;

public class SquareRootOfN {
    static int squareRoot(int n){
        //for a value of n we could divide it from 1 to n such that 1...n/4...n/2...n
//        and then we apply binary seacrh cuz it is in sorted form
        int low=1;
        int high=n;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            int sqr=mid*mid;
            if(n==sqr)
                return mid;
            else if(sqr>n)
                high=mid-1;
            else {
                low = mid + 1;
                res = mid;
            }
        }
        return res;
    }





    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        System.out.println(squareRoot(n));


    }
}
