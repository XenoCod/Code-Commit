package Codes.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbersUptoN {
    static void generateUptoN(int x){
        ArrayDeque<String> q=new ArrayDeque<>();
        q.offer("5");
        q.offer("6");
        for(int i=0;i<x;i++){
            String curr=q.getFirst();
            System.out.print(curr+" ");
            q.poll();
            q.offer(curr+"5");
            q.offer(curr+"6");
            
        }
    }
    public static void main(String[] args) {
        int n=10;
        generateUptoN(n);
    }
}
