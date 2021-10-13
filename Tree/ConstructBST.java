import java.util.*;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int _val){
		val= _val;
	}
}

public class ConstructBST{
	static void bstFromPreorder(int preoder[]){
		TreeNode root= new TreeNode(preoder[0]);
		Stack<TreeNode> st= new Stack<>();
		st.push(root);

		for(int i=1; i< preoder.length; i++){
			TreeNode node= new TreeNode(preoder[i]);


			if(st.peek().val > preoder[i]) st.peek().left= node;
			else{
				TreeNode parent= st.peek();
				while(!st.isEmpty() && st.peek().val < preoder[i]){
					parent= st.peek();
				}
				parent.right= node;
			}
			st.push(node);
		}

		printTreee(root);
	}

	static void printTreee(TreeNode root){
		if(root ==  null) return;

		printTreee(root.left);
		System.out.println(root.val);
		printTreee(root.right);
	}
	public static void main(String[] args) {
		int preoder[]= {8,5,1,7,10,12};
		bstFromPreorder(preoder);
	}
}