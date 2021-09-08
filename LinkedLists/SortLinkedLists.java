package LinkedLists;

class ListNode{
	ListNode next;
	int val;
	ListNode(int _val){
		val= _val;
	}
}

public class SortLinkedLists {
	
	//Merge a LL
	private ListNode sort(ListNode head) {
		 if (head == null || head.next == null) return head;
         ListNode mid = middleNode(head);
         ListNode left = sort(head);
         ListNode right = sort(mid);
         return mergeTwoLists(left, right);
     }

     public ListNode middleNode(ListNode head) {
         ListNode slow = head, fast = head, mid;
         while (fast.next != null && fast.next.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         mid = slow.next;
         slow.next = null;
         return mid;
     }

     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode dummyHead = new ListNode(-1), current = dummyHead;
         while (l1 != null && l2 != null) {
             if (l1.val <= l2.val) {
                 current.next = l1;
                 l1 = l1.next;
             } else {
                 current.next = l2;
                 l2 = l2.next;
             }
             current = current.next;
         }
         current.next = l1 != null ? l1 : l2;
         return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head= new ListNode(4);
		head.next= new ListNode(2);
		head.next.next= new ListNode(3);
		head.next.next.next= new ListNode(1);
		SortLinkedLists ob= new SortLinkedLists();
		ListNode res=ob.sort(head);
		while(res!= null) System.out.println(res.val);
	}
}
