package Codes.Stack;

import java.util.ArrayDeque;

public class StockSpan {
    static void stockSpan(int arr[]){
        ArrayDeque<Integer> s= new ArrayDeque<>();
        s.push(0);
        System.out.println("1");
        for(int i=1;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i])
                s.pop();
            int span=s.isEmpty()?i+1:i-s.peek();
            System.out.println(span);
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[]={13,15,12,14,16,8,6,4,10,30};
//        int arr[]= {10,20,30,40};
        stockSpan(arr);

    }
}
