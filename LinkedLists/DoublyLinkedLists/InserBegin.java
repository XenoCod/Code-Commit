package Codes.LinkedLists.DoublyLinkedLists;

import static Codes.LinkedLists.DoublyLinkedLists.SimpleDoubllyLinkedLits.printList;

public class InserBegin {
    public static Node insertBegin(Node head, int data){
        Node temp= new Node(data);
        temp.next=head;
        if(head!=null){
            head.prev=temp;

        }
        return temp;
    }
    public static Node insertTail(Node head, int end){
        Node temp= new Node(end);
        Node curr= head;
        if(head==null)
            return temp;

        while(curr.next!=null)
            curr=curr.next;

        curr.next=temp;
        temp.prev=curr;
        return  head;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        int data=5;
        int endData=40;
        head=insertBegin(head, data);
        head=insertTail(head, endData);
        printList(head);
    }
}
