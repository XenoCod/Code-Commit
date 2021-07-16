package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class SeggregateEvenAndOdd {
    public static Node segreate(Node head){
        Node evenStart=null, evenEnd=null, oddStart=null, oddEnd=null;
        for(Node curr=head;curr!=null;curr=curr.next){
            int x=curr.data;
            if(x%2==0){
                if (evenStart == null) {
                    evenStart=curr;
                    evenEnd=evenStart;
                }
                else{
                    evenEnd.next=curr;
                    evenEnd=evenEnd.next;
                }
            }
            else {
                if (oddStart == null) {
                    oddStart=curr;
                    oddEnd=oddStart;
                }
                else{
                    oddEnd.next=curr;
                    oddEnd=oddEnd.next;
                }
            }
        }
        if(evenStart==null || oddStart==null)
            return head;
        evenEnd.next=oddStart;
        oddEnd.next=null;
        return evenStart;
    }
    public static void main(String[] args) {
        Node head= new Node(17);
        Node temp1= new Node(15);
        Node temp2= new Node(8);
        Node temp3= new Node(12);
        Node temp4= new Node(10);
        Node temp5= new Node(5);
        Node temp6= new Node(4);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        head=segreate(head);
        printList(head);

    }
}
