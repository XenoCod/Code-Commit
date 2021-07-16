package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class RemoveDuplicates {
    public static void removeDuplicates(Node head){
        if(head==null)
            return  ;
        Node curr= head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data)
                curr.next=curr.next.next;
            else
                curr=curr.next;
        }

    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(20);
        Node temp3= new Node(20);
        Node temp4= new Node(30);
        Node temp5= new Node(30);
        Node temp6= new Node(30);
        Node temp7= new Node(40);
        Node temp8= new Node(50);
        Node temp9= new Node(50);
        Node temp10= new Node(50);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        temp6.next=temp7;
        temp7.next=temp8;
        temp8.next=temp9;
        temp9.next=temp10;
        removeDuplicates(head);
        printList(head);
    }
}
