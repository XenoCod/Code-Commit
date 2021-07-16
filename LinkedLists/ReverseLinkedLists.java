package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class ReverseLinkedLists {
    public static Node reverse(Node head){
        if(head==null)
            return null;
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        Node temp3= new Node(40);
        Node temp4= new Node(50);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        head=reverse(head);
        printList(head);
    }
}
