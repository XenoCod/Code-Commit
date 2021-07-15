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
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        int data=5;
        head=insertBegin(head, data);
        printList(head);
    }
}
