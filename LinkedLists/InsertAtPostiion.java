package Codes.LinkedLists;

import java.util.LinkedList;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class InsertAtPostiion {
    public static Node insertPos(Node head, int pos, int data){
        Node temp= new Node(data);
        if(pos==1){
            temp.next=head.next;
            return  temp;
        }
        Node curr= head;
        for(int i=1;i<pos-2&& curr!=null; i++)
                curr=curr.next;
        if(curr==null)
            return head;
        temp.next=curr.next;//we assign the link of previuos
        curr.next=temp;//we apply the next to created node
        return head;



    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(30);
        Node temp2= new Node(40);
        Node temp3= new Node(50);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        int pos=2;
        int data=20;
        head=insertPos(head,pos, data);

        printList(head);

    }
}
