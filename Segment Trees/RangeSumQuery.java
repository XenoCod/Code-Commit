class NumArray {
    //Creatinga segment tree node
    //left and right are the child of parent node
    class SegmentTreeNode{
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;
        
        
        public SegmentTreeNode(int start, int end){
            this.left= null;
            this.right= null;
            this.start= start;
            this.end= end;
            this.sum= 0;
        }
    }
    
    SegmentTreeNode root=null;

    public NumArray(int[] nums) {
        //when its called we build segment tree
        root= buildTree(nums, 0, nums.length-1);
    }
    
    public SegmentTreeNode buildTree(int nums[], int start, int end){
        //when we are out of boundary stop
        if(start > end)
            return null;
        
        else{
            //Make a curr node
            SegmentTreeNode curr= new SegmentTreeNode(start, end);
        
            //reaching leaf node
            if(start == end)
                curr.sum = nums[start];

            else{
                //Use the mid val to build the tree
                int mid= start + (end - start) / 2;//Avoid overrflow
                curr.left= buildTree(nums, start, mid);
                curr.right= buildTree(nums, mid+1, end);
                curr.sum= curr.left.sum + curr.right.sum;
            }
            return curr;
        }
        
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    public void updateHelper(SegmentTreeNode root, int index, int val){
        //When we encounter a leaf node
        if(root.start == root.end)
            root.sum = val;
        else{
            int mid= root.start + (root.end - root.start) / 2;
            if(index <= mid){
                //Move to the left side as BST
                updateHelper(root.left, index, val);
            }
            else{
                //Move to the right side same as BST
                updateHelper(root.right, index, val);
            }
            //After updating while backtracking update the val of the parent
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return getSumRange(root, left, right);
    }
    
    public int getSumRange(SegmentTreeNode root, int start, int end){
        //when we encounter a index with start and end same
        if(root.start == start && root.end == end)
            return root.sum;
        else{
            //traverse with the help of mid
            int mid= root.start + (root.end - root.start) / 2;
            if(end <= mid){
                //Move to the left side
                return getSumRange(root.left, start, end);
            }
            else if(start >= mid+1){
                //Move to the right side
                return getSumRange(root.right, start, end);
            }
            else{
                //take the worsr case and move to both side
                return getSumRange(root.left, start, mid) + getSumRange(root.right, mid+1, end);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

class RangeSumQuery{
	public static void main(String[] args) {
		int nums[]={1,3,5};
		NumArray obj= new NumArray(nums);
		System.out.println(obj.sumRange(0,2));
		obj.update(1, 2);
		System.out.println(obj.sumRange(0,2));
	}
}