package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class SearchInLinkedLists {
    public static int search(Node head, int key){

        int i=1;
        Node curr= head;
        while(curr.next!=null){
            if(curr.data==key)
                return i;
            else {
                curr = curr.next;
                i++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(30);
        Node temp2= new Node(40);
        Node temp3= new Node(50);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        int key=30;
//        key=20;
        int res=search(head,key);

        System.out.println(res);
        printList(head);

    }
}
