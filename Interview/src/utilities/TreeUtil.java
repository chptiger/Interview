package utilities;

import java.util.ArrayList;
import java.util.List;

import entities.TreeNode;

public class TreeUtil {

	/*
	 * Examples:
	 * 
	 * 5 / \ 9 12 / \ \ 2 3 14
	 * 
	 */
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(14);

		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;

		return root;
	}

	public static List<Integer> traverseTreeInOrder(TreeNode root) {
		List<Integer> printer = new ArrayList<>();
		traverseTreeInOrderHelper(root, printer);
		return printer;
	}

	private static void traverseTreeInOrderHelper(TreeNode root, List<Integer> printer) {
		if (root == null) {
			return;
		}
		traverseTreeInOrderHelper(root.left, printer);
		printer.add(root.key);
		traverseTreeInOrderHelper(root.right, printer);
	}

	public static boolean identicalTrees(TreeNode rootOne, TreeNode rootTwo) {
		/* 1. both empty */
		if (rootOne == null && rootTwo == null) {
			return true;
		}

		/* 2. both non-empty -> compare them */
		if (rootOne != null && rootTwo != null) {
			return rootOne.key == rootTwo.key && identicalTrees(rootOne.left, rootTwo.left)
					&& identicalTrees(rootOne.right, rootTwo.right);
		}

		/* 3. one empty, one not -> false */
		return false;
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static boolean ifMirrorTrees(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		}

		if (one == null || two == null) {
			return false;
		}

		return one.key == two.key && ifMirrorTrees(one.left, two.right) && ifMirrorTrees(one.right, two.left);
	}

	public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}

		TreeNode ll = findLowestCommonAncestor(root.left, one, two);
		TreeNode rr = findLowestCommonAncestor(root.right, one, two);

		if (ll != null && rr != null) {
			return root;
		}

		return ll != null ? ll : rr;
	}

	/*
	 * public static String print(TreeNode root) {
	 * 
	 * }
	 */
}
