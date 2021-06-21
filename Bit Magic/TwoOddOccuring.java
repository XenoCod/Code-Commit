import java.util.ArrayList;
import java.util.Scanner;

public class TwoOddOccuring {
    static void twoOddOccuring(int arr[], int n){
        int ans[]= new int[2];
        int xor=0, res1=0, res2=0;
        for(int i=0;i<n;i++)
            xor^=arr[i];

        int temp=xor&(~(xor-1));//stores the rightmost bit

        for(int i=0;i<n;i++){
            if((temp&arr[i])!=0)
                res1^=arr[i];
            else
                res2^=arr[i];
        }
        System.out.print(res1+" "+res2);
        System.out.println();
        //We get the XOR of the two odd occurring element and then we divide the original array into 2 group i.e one would have last  bit as 1 and the other group will have the last bit as 0. Then we again XOR the both group with the XOR sum obtained from 2 odd occuring element and the only two element we obtained after this would be the answer.
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        twoOddOccuring(arr,n);

    }
}