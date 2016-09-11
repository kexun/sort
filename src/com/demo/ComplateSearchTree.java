package com.demo;

import java.util.LinkedList;

public class ComplateSearchTree {

	public static void main(String[] args) {

		Tree head = new Tree(70);
		Tree h1 = new Tree(40);
		Tree h2 = new Tree(100);
		Tree h3 = new Tree(20);
		Tree h4 = new Tree(50);
		Tree h5 = new Tree(45);
		Tree h6 = new Tree(55);
		Tree h7 = new Tree(53);
		Tree h8 = new Tree(59);
		Tree h9 = new Tree(80);
		Tree h10 = new Tree(110);
		
		head.left = h1;
		head.right = h2;
		h1.left = h3;
		h1.right = h4;
		h4.left = h5;
		h4.right = h6;
		h6.left = h7;
		h6.right = h8;
		h2.left = h9;
		h2.right = h10;
		ComplateSearchTree c = new ComplateSearchTree();
		boolean re = c.isSearchTree(head);
		System.out.println(re);
		
		boolean re2 = c.isComplateTree(head);
		System.out.println(re2);
		
	}

	/**
	 * 判断是否是搜索二叉树，利用morris中序遍历二叉树
	 * @param head
	 * @return
	 */
	public boolean isSearchTree(Tree head) {
		
		if (head == null) {
			return true;
		}
		
		boolean result = true;
		Tree c1 = head;
		Tree c2 = null;
		Tree pre = null;
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
			
			if (pre != null && pre.data > c1.data) {
				result = false;
			}
			pre = c1;
			c1 = c1.right;
		}
		
		return result;
	}
	
	/**
	 * 判断是否是完全二叉树
	 * @param head
	 * @return
	 */
	public boolean isComplateTree(Tree head) {
		
		
		if (head == null) {
			return true;
		}
		
		boolean leaf = false;
		LinkedList<Tree> queue = new LinkedList<Tree>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			
			Tree node = queue.poll();
			Tree r = node.right;
			Tree l = node.left;
			if ((leaf && (l!=null && r!=null)) || (l==null & r!=null)) {
				return false;
			}
		
			if (l != null) {
				queue.offer(l);
			}
			
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		
		return true;
	}
	
	
}
