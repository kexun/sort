package com.demo;

/**
 * morris遍历树，在时间复杂度为O(n),空间复杂度O(1)的前提下，遍历二叉树。
 * @author kexun
 *
 */
public class MorrisTree {

	public static void main(String[] args) {


		Tree head = new Tree(1);
		Tree h2 = new Tree(2);
		Tree h3 = new Tree(3);
		Tree h4 = new Tree(4);
		Tree h5 = new Tree(5);
		Tree h6 = new Tree(6);
		Tree h7 = new Tree(7);
		Tree h8 = new Tree(8);
		Tree h9 = new Tree(9);
		Tree h10 = new Tree(10);
		
		head.left = h2;
		head.right = h3;
		h2.left = h4;
		h2.right = h5;
		h4.left = h6;
		h5.right = h7;
		h3.left = h8;
		h3.right = h9;
		h9.right = h10;
	
		MorrisTree v = new MorrisTree();
		v.morrisInTree(head);
		
	
	}

	/**
	 * morris遍历  中序
	 * @param head
	 */
	public void morrisInTree(Tree head) {
		if (head == null) {
			return;
		}
		
		Tree c1 = head;
		Tree c2 = null;
		
		while (c1 != null) {
			c2 = c1.left;
			if (c2 != null) {
				while (c2.right != null && c2.right != c1) {
					c2 = c2.right;
				}
				
				if (c2.right == null) {
					c2.right = c1;
					c1 = c1.left;
					continue;
				} else {
					c2.right = null;
				}
			}
			System.out.println(c1.data);
			c1 = c1.right;
			
		}
		
	}
	
}
