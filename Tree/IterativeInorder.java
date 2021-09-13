package Tree;

import java.util.Stack;

public class IterativeInorder {
	
	void traverse(TreeNode root) {
//		if(root == null) return list;
        Stack<TreeNode> st= new Stack<>();
        while(true){
            //go till the leftmost subtree
            if(root!= null){
                st.push(root);
                root= root.left;
            }
            else{
                //When it is on the last left subtree
                if(st.isEmpty()) break;
                
                
                root= st.pop();
//                list.add(root.val);
                System.out.println(root.data);
                root= root.right;
            }
        }
	}
public static void main(String[] args) {
	TreeNode root= new TreeNode(1);
	root.left= new TreeNode(2);
	root.right= new TreeNode (7);
	root.left.left= new TreeNode (3);
	root.left.right= new TreeNode (4);
	root.left.right.left= new TreeNode(5);
	root.left.right.right= new TreeNode(6);
	IterativeInorder obj= new IterativeInorder();
	obj.traverse(root);
}
}
