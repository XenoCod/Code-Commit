package Codes.Queue;


import java.util.ArrayDeque;

class Queeue{
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;
    Queeue(){
        q1=new ArrayDeque<>();
        q2=new ArrayDeque<>();
    }
    void enqueue(int x){
        while(!q1.isEmpty()){
            q2.push(q1.peek());
            q1.pop();
        }
        q1.push(x);
        while(!q2.isEmpty()){
            q1.push(q2.peek());
            q2.pop();
        }
    }
    void dequeue(){
        q1.pop();
    }
    int getSize(){
        return q1.size();
    }
    int getFront(){
        return q1.peek();
    }

}
public class QueueUsingStacks {
    public static void main(String[] args) {
        Queeue q= new Queeue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(q.getFront());
        System.out.println(q.getSize());
        q.dequeue();
        System.out.println(q.getFront());

    }
}
