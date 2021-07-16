package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class InsertSorted {
    public static Node insertSorted(Node head, int key){
        Node temp= new Node(key);
        if(head==null)
            return temp;
        if(head.data>key){
            temp.next=head;
            return head;

        }
        Node curr= head;
        while(curr.next!=null && curr.next.data<key)
                curr=curr.next;
        temp.next=curr.next;
        curr.next=temp;
        return head;




    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.next=temp2;
        int key=25;
        head= insertSorted(head, key);
        printList(head);
    }
}
