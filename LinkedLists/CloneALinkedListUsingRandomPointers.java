package Codes.LinkedLists;


import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class CloneALinkedListUsingRandomPointers {
    public static Node cloneLinkedList(Node head){
        Node curr=head, temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=new Node(curr.data);
            curr.next.next=temp;
            curr=temp;

        }

        for(Node curr1=head;curr1!=null;curr1=curr1.next.next){
            curr1.next.random=(curr1.random!=null)?curr1.random.next:null;

        }

        Node original=head, copy=head.next;
        Node res=copy;
        while(original!=null){
            original.next=original.next.next;
            copy.next=(copy.next!=null)?copy.next.next:copy.next;
            original=original.next;
            copy=copy.next;
        }
        return res;
    }
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;
        start=cloneLinkedList(start);
        printList(start);
    }
}
