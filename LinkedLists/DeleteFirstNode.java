package Codes.LinkedLists;

import java.awt.*;

import static Codes.LinkedLists.TraversalOfLinkedLists.printList;

public class DeleteFirstNode {
    public static void main(String[] args) {
        Node head= new Node(10);
        Node temp1= new Node(20);
        Node temp2= new Node(30);
        deleteFirstNode(head);
        printList(head);
    }
}
