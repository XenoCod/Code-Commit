package Codes.GreddyAlgorithm;

import java.util.PriorityQueue;

class Node {
    char ch;
    int freq;
    Node left, right;
    Node (char c, int f, Node l, Node r){
        ch=c;
        freq=f;
        left=l;
        right=r;
    }
}

public class HuffManCoding {
    static void huffManCode(char arr[], int val[]){
        PriorityQueue<Node> pq= new PriorityQueue<>((a, b)-> a.freq-b.freq);
        for(int i=0;i<arr.length;i++)
            pq.add(new Node(arr[i], val[i], null, null));
        while(pq.size()>1){
            Node l=pq.poll();
            Node r=pq.poll();
            pq.add(new Node('$', l.freq+r.freq,l, r));

        }

        printTree(pq.peek(), "");
    }


    static void printTree(Node root , String str){
            if(root==null)
                return;
            if(root.ch!='$'){
                System.out.print(root.ch+" "+str);
                System.out.println();
            }
            printTree(root.left, str+"0");
            printTree(root.right,str+"1");
    }

    
    public static void main(String[] args) {
        char arr[]={'a', 'd', 'b', 'e', 'f'};
        int val[]={10, 50, 20, 40, 80};
        huffManCode(arr, val);
    }
}
