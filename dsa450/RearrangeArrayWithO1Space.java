package Codes.dsa450;

import java.util.ArrayList;

public class RearrangeArrayWithO1Space {
    static void rearrange(int arr[]){
//        Using O(n) extra space
//        ArrayList<Integer> pos= new ArrayList<>();
//        ArrayList<Integer> neg= new ArrayList<>();
//        for(int i:arr) {
//            if (i < 0)  neg.add(i);
//            else        pos.add(i);
//        }
//        int n1=pos.size(), n2=neg.size(), i=0, j=0, k=0, n=arr.length;
//        while(i<n1 && j<n2 && k<n){
//            arr[k++]=neg.get(j++);
//            arr[k++]=pos.get(i++);
//        }
//        while(i<n1) arr[k++]=pos.get(i++);
//        while(j<n2) arr[k++]=neg.get(j++);

//        Using O(1) space

        int posIndex=0 , negIndex=0;
        int n=arr.length;
        int index=0;
        while(index<n && posIndex<n && negIndex< n){
            if(index%2==0 && arr[index]>=0){
                posIndex=index;
                negIndex=index;
                while(arr[posIndex]>=0 && posIndex<n) posIndex++;
                if(posIndex>=n) break;
                rotate(arr, negIndex, posIndex);

            }
            else {
                if(arr[index]<0){
                    posIndex=index; negIndex=index;
                    while(negIndex<n && arr[negIndex]<0) negIndex++;
                    if(negIndex>n) break;;
                    rotate(arr, posIndex, negIndex);
                }
            }
            index++;
        }



    }
    static void rotate(int nums[], int start, int end){
        int temp=nums[end ];
        for(int i=end-1;i>=start;i--)
            nums[i+1]=nums[i];
        nums[start]=temp;
    }
    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4,
                7, 1, 8, 0, -8};
        rearrange(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
