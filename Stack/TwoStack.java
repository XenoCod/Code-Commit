package Codes.Stack;


class TwoStacks{
    int cap,top1, top2, arr[];
    TwoStacks(int x){
        cap=x;
        top1=-1;
        top2=cap;
        arr= new int[cap];
    }
    void push1(int x){
        if(top1<top2-1) {
            top1++;
            arr[top1] = x;
        }
    }
    void push2(int x){
        if(top1<top2-1) {
            top2--;
            arr[top2] = x;
        }
    }
    int pop1(){
        if(top1>=0) {
            int res = arr[top1];
            top1--;
            return res;
        }
        return -1;
    }
    int pop2(){
        if(top2<cap) {
            int res = arr[top2];
            top2--;
            return res;
        }
        return -1;
    }
}

public class TwoStack {
    public static void main(String[] args) {
        TwoStacks s= new TwoStacks(5);
        s.push1(1);
        s.push1(2);
        s.push1(3);
        System.out.println(s.pop1());
        s.push2(4);
        s.push2(5);
        s.push2(6);
        System.out.println(s.pop2());
    }
}
