package Codes.LinkedLists.DoublyLinkedLists;

import static Codes.LinkedLists.DoublyLinkedLists.SimpleDoubllyLinkedLits.printList;

public class DeleteFirstNode {
    public static Node deletFirst(Node head){
        if(head==null)
            return null;
        if(head.next==null)
            return null;
        else{
            head=head.next;
            head.prev=null;
            return head;
        }
    }

    public static Node deleteLast(Node head){
        if(head==null || head.next==null)
            return null;
        Node curr= head;
        while(curr.next!=null)
            curr=curr.next;
        curr.prev.next=null;
        return head;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        head=deletFirst(head);
        head=deleteLast(head);
        printList(head);

    }
}
