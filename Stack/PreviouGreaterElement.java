package Stack;
//Aka next greater element to the left

import java.util.ArrayDeque;

public class PreviouGreaterElement {
    static void prevGreater(int arr[]){
        ArrayDeque<Integer> s= new ArrayDeque<>();
        s.push(arr[0]);
        System.out.println("-1");
        for(int i=1;i< arr.length;i++){
            while(!s.isEmpty() && s.peek()<=arr[i])
                s.pop();
            int pos=s.isEmpty()?-1:s.peek();
            System.out.print(pos+" ");
            s.push(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[]= {15,10,18,12, 4 ,6,2, 8};
        prevGreater(arr);
    }
}
