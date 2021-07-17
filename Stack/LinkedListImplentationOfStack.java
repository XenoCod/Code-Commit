package Codes.Stack;

class Node {
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class Stack{
    Node head;
    int size;
    Stack(){
        head= null;
        size=0;
    }

    void push(int x){
        Node temp= new Node(x);
        temp.next=head;
        head=temp;
        size++;
    }
    int pop(){
        int res=head.data;
        head=head.next;
        size--;
        return res;
    }

    boolean isEmpty(){
        return (head==null);
    }

    int peek(){
        if(head==null)
            return Integer.MIN_VALUE;
        return head.data;
    }

    int size(){
        return size;
    }




}

public class LinkedListImplentationOfStack {
    public static void main(String[] args) {
        Stack stack= new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(50);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

    }
}
