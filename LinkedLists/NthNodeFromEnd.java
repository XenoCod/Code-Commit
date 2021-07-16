package Codes.LinkedLists;

public class NthNodeFromEnd {
    public static void getNthFromEnd(Node head, int key){
        if(head==null)
            return;
        Node first=head, second=head;
        for(int i=0;i<key;i++){
            if(first==null)
                return;
            first=first.next;
        }

        while(first!=null){
            first=first.next;
            second=second.next;
        }
        System.out.println(second.data);
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
        int key=4;
        getNthFromEnd(head, key);


    }
}
