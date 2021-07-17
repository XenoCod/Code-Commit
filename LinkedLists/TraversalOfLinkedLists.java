
package Codes.LinkedLists;

class Node{
    int data;
    Node next,random;

    Node(int x){
        data=x;
        next=null;
        random=null;


    }
}

public class TraversalOfLinkedLists {
    public static void printRecursive(Node head){
        if(head==null)
            return ;
        System.out.print(head.data+" ");
        printList(head.next);
    }

    public  static void printList(Node head){
        Node curr= head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.next=temp2;
        printList(head);
        System.out.println();
        printRecursive(head);

    }
}
