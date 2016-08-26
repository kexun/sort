package com.demo;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along 
 * the shortest path from the root node down to 
 * the nearest leaf node.
 * @author kexun
 *
 */
public class MinTree {
	public int run(TreeNode root) {
	     
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return run(root.right)+1;
        }
        if (root.right == null) {
            return run(root.left)+1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }
	
	class TreeNode {
		public TreeNode left;
		public TreeNode right;
	}
	
	public static void main(String[] args) {
		TreeNode root = new MinTree(). new TreeNode();
		root.left = new MinTree(). new TreeNode();
		root.right = new MinTree(). new TreeNode();
		
		MinTree t = new MinTree();
		int i = t.run(root);
		System.out.println(i);
	}
}
