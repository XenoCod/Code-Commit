package Codes.LinkedLists;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class MergeAndSortTwoLinkedLits {
    public static Node mergeAndSort(Node a, Node b){
        if(a==null)
            return b;
        if(b==null)
            return a;
        Node head= null,tail=null;
        if (a.data <= b.data) {
            head=tail=a;
            a=a.next;
        }
        else {
            head=tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(a==null)
            tail.next=b;
        else
            tail.next=a;
        return head;


    }
    public static void main(String[] args) {
        Node a= new Node(10);
        a.next=new Node(20);
        a.next.next=new Node(30);
        a.next.next.next=new Node(40);
        a.next.next.next.next=new Node(44);

        Node b= new Node(5);
        b.next=new Node(25);
        b.next.next=new Node(35);
        b.next.next.next=new Node(45);

        a=mergeAndSort(a,b);
        printList(a);
    }
}
