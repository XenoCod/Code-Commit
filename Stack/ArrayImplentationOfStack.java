package Codes.Stack;

class MyStack{
    int arr[];
    int capacity;
    int top;
    MyStack(int c){
        capacity=c;
        top=-1;
        arr= new int [capacity];
    }
    void push(int x){
        if(top==capacity-1)
            System.out.println("Error: Stack Overflow");
        top++;
        arr[top]=x;
    }
    int pop(){
        if(top==-1)
            System.out.println("Error: Stack Underflow");
        int res=arr[top];
        top--;
        return res;

    }

    int peek(){
        if(top==-1)
            System.out.println("Error: Stack Underflow");
        return arr[top];
    }

    boolean isEmpty(){
        return (top==-1);
    }
    int size(){
        return top;
    }
}

public class ArrayImplentationOfStack {

    public static void main(String[] args) {
        MyStack stack= new MyStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
//        System.out.println(stack.peek());
        stack.pop();
//        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        stack.pop();
//        stack.pop();
//        System.out.println(stack.peek());

    }
}
