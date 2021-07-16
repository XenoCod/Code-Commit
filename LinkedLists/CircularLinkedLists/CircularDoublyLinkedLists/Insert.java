package Codes.LinkedLists.CircularLinkedLists.CircularDoublyLinkedLists;


class Node{
    int data;
    Node prev;
    Node next;
    Node(int x){
        data=x;
        prev=null;
        next=null;
    }
}

public class Insert {
    public static void printList(Node head){
        if(head==null)
            return;
        Node curr=head;

        do{
            System.out.print(curr.data+" ");
            curr=curr.next;
        }while (curr!=head);
    }
    public static Node insertBegin(Node head, int key){
        Node temp= new Node(key);
        if(head==null){
            temp.next=temp;
            temp.prev=temp;
            return temp;
        }
        temp.prev=head.prev;
        temp.next=head;
        head.prev.next=temp;
        head.prev=temp;
        return temp;
    }
    public static Node insertEnd(Node head, int key){
        Node temp= new Node(key);
        if(head==null){
            temp.next=temp;
            temp.prev=temp;
            return temp;
        }
        temp.prev=head.prev;
        temp.next=head;
        head.prev.next=temp;
        head.prev=temp;
        return head;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        head.next=temp1;
        head.prev=temp2;
        temp1.next=temp2;
        temp1.prev=head;
        temp2.prev=temp1;
        temp2.next=head;
        int start=5;
        int end=40;
        head=insertBegin(head,start);
        head=insertEnd(head,end);
        printList(head);
    }
}
