// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
/*
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
*/

class NodesBetweeenCp{
	static int[] nodesBetweeenCp(ListNode head){
		 int minDis=Integer.MAX_VALUE, maxDis= -1;
        ListNode curr=head, prev= null;
        int prevCp=0, firstCpNode=0;
        int index=0;
        
        while(curr != null){
            if(curr.next != null && prev != null){
                if((curr.val > prev.val && curr.val > curr.next.val)
                   || curr.val < prev.val && curr.val < curr.next.val){
                    if(firstCpNode == 0){
                        firstCpNode = index;
                    }
                    else{
                        minDis= Math.min(minDis, index - prevCp);
                        maxDis= Math.max(maxDis, index - firstCpNode);
                    }
                    prevCp= index;
                }
            }
            index++;
            prev= curr;
            curr= curr.next;
            
        }
        return minDis == Integer.MAX_VALUE ? new int[]{-1, -1} : new int []{minDis, maxDis};
	}
	public static void main(String[] args) {
		nodesBetweeenCp(head);
	}
}