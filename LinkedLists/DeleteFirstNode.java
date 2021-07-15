package Codes.LinkedLists;

import java.awt.*;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class DeleteFirstNode {
    public static Node deleteFirstNode(Node head){
        if(head==null)
            return null;
        else
            return head.next;
    }
    public static Node deleteLastNode(Node head){
        if(head==null || head.next==null)
            return null;
       Node curr= head;
       while(curr.next.next!=null)
           curr=curr.next;
       curr.next=null;
       return head;

    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.next=temp2;
//        head=deleteFirstNode(head);
        head=deleteLastNode(head);

        printList(head);
    }

}
