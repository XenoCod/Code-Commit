package Codes.Queue;

class Node {
    Node next;
    int data;
    Node(int x){
        data=x;
        next=null;
    }

}

class MyQueue{
    Node front, rear;
    int size;
    MyQueue(){
        front=rear=null;
        size=0;
    }
    void enqueue(int x){
        size++;
        Node temp= new Node(x);
        if(front==null){

            front=rear=temp;
            return;
        }
        rear.next=temp;
        rear=temp;
    }
    void dequeue(){
        if(front==null)
            return;
        front=front.next;
        if(front==null)
            rear=null;
    }
    int getFront(){
        if(front==null)
            return -1;
        return front.data;
    }
    int getLast(){
        if(rear==null)
            return -1;
        return rear.data;
    }
    int getSize(){
        return size;
    }



}

public class QueueUsingLinkedLists {
    public static void main(String[] args) {
        MyQueue q= new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        System.out.println(q.getFront());
        System.out.println(q.getLast());
        System.out.println(q.getSize());
        q.enqueue(40);
        System.out.println(q.getLast());
    }
}
