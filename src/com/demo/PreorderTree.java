package com.demo;

import java.util.ArrayList;
import java.util.Stack;


public class PreorderTree {

	public static void main(String[] args) {
		TreeNode root = new PreorderTree().new TreeNode(1);
		TreeNode root1 = new PreorderTree().new TreeNode(2);
		TreeNode root2 = new PreorderTree().new TreeNode(3);
		root.left = root1;
		root.right = root2;
		
		PreorderTree p = new PreorderTree();
		ArrayList<Integer> list = p.preorderTraversal(root);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (root != null) {
			traversal(root, list);
		}
		
		return list;
    }

	public void traversal(TreeNode root, ArrayList<Integer> list) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			list.add(top.val);
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
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
