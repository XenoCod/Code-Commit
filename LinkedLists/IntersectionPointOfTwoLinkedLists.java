package Codes.LinkedLists;

import java.nio.file.NotDirectoryException;

public class IntersectionPointOfTwoLinkedLists {
    public static int count(Node head){
        int ans=0;
        Node temp=head;
        while(temp!=null){
            ans++;
            temp=temp.next;
        }
        return ans;
    }
    public static int findIntersection(Node head, Node head2){
        int count1=count(head), count2=count(head2);
        if(count1>count2){
            int d=count1-count2;
            return getIntersection(d,head, head2);
        }
        else{
            int d=count2-count1;
            return getIntersection(d, head2, head);
        }
    }
    public static int getIntersection(int d, Node head, Node head2){
        Node large=head, small=head2;
        for(int i=0;i<d;i++){
            if(large==null)
                return -1;
            large=large.next;

        }
        while(large!=null && small!=null){
            if(large.data==small.data)
                return large.data;
            large=large.next;
            small=small.next;
        }
        return  -1;
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

        Node head2= new Node(19);
//        Node temmp= new Node(20);
//        head2.next=temmp;
        head2.next=temp3;
        System.out.println(findIntersection(head, head2));
    }
}
