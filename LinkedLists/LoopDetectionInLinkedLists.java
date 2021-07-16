package Codes.LinkedLists;

public class LoopDetectionInLinkedLists {
    public static boolean isLoop(Node head){
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;

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
        temp4.next=temp2;
        System.out.println(isLoop(head));
    }
}
