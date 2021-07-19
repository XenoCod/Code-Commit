package Codes.Queue;

import java.util.ArrayDeque;

public class ReverseQueue {
    static void reverse(ArrayDeque<Integer>q){
        ArrayDeque<Integer>s= new ArrayDeque<>();
        while(!q.isEmpty())
            s.push(q.poll());

        while(!s.isEmpty())
            q.offer(s.pop());
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> q= new ArrayDeque<>();
        q.offer(10);
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}
