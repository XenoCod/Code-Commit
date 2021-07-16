package Codes.LinkedLists.CircularLinkedLists;

import static Codes.LinkedLists.CircularLinkedLists.TraversalCircularLinkedList.printList;

public class DeleteKthNode {
    public static Node deleteKthNode(Node head, int k){
        if(head==null || head.next==head)
            return null;
        if(k==1){
            head.data=head.next.data;
            head.next=head.next.next;
            return head;
        }
        Node curr= head;
        for(int i=0;i<k-2;i++)
            curr=curr.next;
        curr.next=curr.next.next;
        return head;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=head;
        int k=3;
        head= deleteKthNode(head, k);
        printList(head);
    }
}
