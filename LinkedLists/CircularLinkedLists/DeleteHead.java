package Codes.LinkedLists.CircularLinkedLists;

import static Codes.LinkedLists.CircularLinkedLists.TraversalCircularLinkedList.printList;

public class DeleteHead {
    public  static Node deleteHead(Node head){
        if(head==null || head.next==head)
            return null;
        else{
            Node curr= head;

           while(curr.next!=head)
               curr=curr.next;
           curr.next=head.next;
           return curr.next;
        }
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head;
        head= deleteHead(head);
        printList(head);
    }
}
