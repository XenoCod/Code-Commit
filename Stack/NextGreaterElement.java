package Codes.Stack;

import java.util.ArrayDeque;

public class NextGreaterElement {
    static void nextGreater(int arr[]){
        int n=arr.length;
        ArrayDeque<Integer> s= new ArrayDeque<>();
        s.push(arr[n-1]);
        System.out.println("-1");
        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i])
                s.pop();
            int elem=s.isEmpty()?-1:s.peek();
            System.out.println(elem);
            s.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[]={5,15,10,8,6,12,9,18};
        nextGreater(arr);
    }
}
