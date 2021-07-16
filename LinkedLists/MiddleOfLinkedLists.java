package Codes.LinkedLists;

public class MiddleOfLinkedLists {
    public static void showMiddle(Node head){
        if(head==null)
            return;
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        System.out.println(slow.data);


    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        temp1.next=temp2;
        showMiddle(head);
    }
}
