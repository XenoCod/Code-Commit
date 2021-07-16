package Codes.LinkedLists.CircularLinkedLists;

import static Codes.LinkedLists.CircularLinkedLists.TraversalCircularLinkedList.printList;

public class InsertAtBegin {
    public static Node insertStart(Node head, int data){
        Node temp= new Node(data);
        if(head==null){
            temp.next=temp;
            return temp;
        }
        else {
            temp.next=head.next;
            head.next=temp;
            int t=head.data;
            head.data=temp.data;
            temp.data=t;
            return head;
        }
    }
    public static Node insertEnd(Node head, int data){
        Node temp= new Node(data);
        if(head==null){
            temp.next=temp;
            return temp;
        }
        else{
            temp.next=head.next;
            head.next=temp;
            int t=temp.data;
            temp.data= head.data;
            head.data=t;
            return temp;
        }
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head;
        int data=5, dataEnd=50;
        head=insertStart(head, data);
        head=insertEnd(head, dataEnd);
        printList(head);
    }
}
