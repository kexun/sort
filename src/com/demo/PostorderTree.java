package com.demo;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTree {

	public static void main(String[] args) {

		TreeNode root = new PostorderTree().new TreeNode(3);
		TreeNode root1 = new PostorderTree().new TreeNode(1);
		TreeNode root2 = new PostorderTree().new TreeNode(2);
		root.left = root1;
		root.right = root2;
		
		PostorderTree p = new PostorderTree();
		ArrayList<Integer> list = p.postorderTraversal2(root);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	/**
	 * 最常用的递归方式
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
    
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traversal(root, list);
		}
		return list;
    }
	
	public void traversal(TreeNode root, ArrayList<Integer> list) {
		
		if (root == null) {
			return;
		}
		
		traversal(root.left, list);
		traversal(root.right, list);
		list.add(root.val);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 非递归，迭代的方式
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traversal2(root, list);
		}
		return list;
    }

	public void traversal2(TreeNode root, ArrayList<Integer> list) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if (top.left == null && top.right == null) {
				list.add(top.val);
				stack.pop();
			} else {
				if (top.right != null) {
					stack.push(top.right);
					top.right = null;
				}
				if (top.left != null) {
					stack.push(top.left);
					top.left = null;
				}
			}
		}
	}
}
