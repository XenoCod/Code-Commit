package Codes.dsa450;

import java.util.Arrays;

public class MergeSortedArrayWithoutSpace {
    static void sort(int a1[], int a2[]){
        int i=a1.length-1, j=0;
        while(i>=0 && j<a2.length){
            if(a1[i]>a2[j]){
                int temp=a1[i];
                a1[i]=a2[j];
                a2[j]=temp;
            }
            i--; j++;
        }
        Arrays.sort(a1); Arrays.sort(a2);


    }
    public static void main(String[] args) {
        int a1[]={1,4,7,8,10};
        int a2[]={2, 3, 9};
        sort(a1, a2);

        for(int i:a1)
            System.out.print(i+" ");
        for(int i:a2)
            System.out.print(i+ " ");
    }
}
