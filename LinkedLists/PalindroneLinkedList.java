package Codes.LinkedLists;

class Nod{
    char data;
    Nod next;
    Nod(char ch){
        data=ch;
        next=null;
    }
}

public class PalindroneLinkedList {
    public  static Nod reverseList(Nod head){
        Nod curr= head, prev=null;
        while(curr!=null){
            Nod next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }return prev;

    }
    public static boolean isPalindrone(Nod head){
        if(head==null)
            return false;
        Nod slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        Nod curr=head;
        slow=head;
        Nod rev= reverseList(slow.next);
        while (curr!=null){
            if(curr.data!=rev.data)
                return false;
            curr=curr.next;
            rev=rev.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Nod head= new Nod('R');
        head.next= new Nod('A');
        head.next.next= new Nod('D');
        head.next.next.next= new Nod('A');
        head.next.next.next.next= new Nod('R');
//        head.next.next.next.next= new Nod('A');

        System.out.println(isPalindrone(head));



    }
}
