package prepare.la.sony;

import java.util.Stack;

import org.junit.Test;

import entities.TreeNode;
import utilities.TreeUtil;

/*
 * Examples:
 
		 5
	   /   \
	  9     12
	 /  \      \
	2    3      14
	
 */
public class BinaryTreeZigzagLevelOrderTraversal_102 {
	
	@Test
	public void test_zigZagTraversal() {
		TreeNode root = TreeUtil.createTree();
		System.out.println(zigZagTraversal(root));
	}
	
	private static String zigZagTraversal(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		Stack<TreeNode> s1 = new Stack();
		Stack<TreeNode> s2 = new Stack();
		s1.add(root);
		StringBuilder sb = new StringBuilder();
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				TreeNode tmp = s1.pop();
				sb.append(tmp.key);
				if(tmp.left != null) {
					s2.add(tmp.left);
				}
				if(tmp.right != null) {
					s2.add(tmp.right);
				}
			}
			while(!s2.isEmpty()) {
				TreeNode tmp = s2.pop();
				sb.append(tmp.key);
				if(tmp.right != null) {
					s1.add(tmp.right);
				}
				if(tmp.left != null) {
					s1.add(tmp.left);
				}
			}
		}
		return sb.toString();
	}

}
