package Codes.dsa450;

import java.util.ArrayList;

public class FindCommonInThreeSortedArrays {
    static ArrayList<Integer> findCommon(int A[], int B[], int C[], int n1, int n2, int n3){
        int i=0, j=0, k=0;
        ArrayList <Integer> res= new ArrayList<>();
        while(i<n1 && j< n2 && k< n3){
            if(A[i]<B[j]) i++; //A's element is small so A pointer moves ahead;
            else if (A[i]>B[j]) j++; //B's element is small so B pointer moves ahead
            //Else  condition is only achieved when both elements of A and B are true

            else{
                //Checking for duplicate element in A

                if(i>0 && A[i]==A[i-1]) {
                    i++;
                    continue;
                }
                while(k<n3 && C[k]<B[j]) k++;
                if(k<n3 && C[k]==B[j]) res.add(B[j]);
                i++; j++;
            }


        }
        return res;
    }
    public static void main(String[] args) {
        int n1 = 6; int A[] = {1, 5, 10, 20, 40, 80};
        int n2 = 5; int B[] = {6, 7, 20, 80, 100};
        int n3 = 8; int C[] = {3, 4, 15, 20, 30, 70, 80, 120};
        ArrayList<Integer> ans= findCommon(A,B,C,n1, n2, n3);
        System.out.println(ans);
    }
}
