package LinkedLists;

class ListNode{
	ListNode next;
	int val;
	ListNode(int _val){
		val= _val;
	}
}

public class SortLinkedLists {
	
	
	public ListNode sortList(ListNode head) {
        //Step 1: Find the midddle node
        //Step 2: Break the list
        //Step 3: Sort the list
        //Step 4: MErge the list
        if(head == null || head.next == null) return head;
        
        //Finding middle node
        ListNode prev= null, slow= head, fast= head;
        while(fast != null && fast.next != null){
            prev= slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        
        //Breaking the list into 2
        prev.next= null;
        
        ListNode left= sortList(head);
        ListNode right = sortList(slow);
        
        //Merge the list
        return merge(left, right);
        
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy= new ListNode(0);
        ListNode curr= dummy;
        ListNode curr1= l1;//runner for l1
        ListNode curr2= l2;//runner for l1
        
        while(curr1 != null || curr2 != null){
            if(curr1 == null){
                curr.next= curr2;
                break;
            }
            
            else if(curr2 == null){
                curr.next= curr1;
                break;
            }
            
            else{
                if(curr1.val <= curr2.val){
                    curr.next= curr1;
                    curr1= curr1.next;
                }
                else{
                    curr.next= curr2;
                    curr2= curr2.next;
                }
                
                curr= curr.next;
            }
            
            
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head= new ListNode(4);
		head.next= new ListNode(2);
		head.next.next= new ListNode(3);
		head.next.next.next= new ListNode(1);
		SortLinkedLists ob= new SortLinkedLists();
		ListNode res=ob.sortList(head);
		while(res!= null) { 
			System.out.print(res.val+" "); 
			res= res.next;
		} 
	}
}
