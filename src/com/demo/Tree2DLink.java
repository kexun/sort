package com.demo;

/**
 * 二叉树转双向链表
 * 利用中序的性质。
 * @author kexun
 *
 */
public class Tree2DLink {

	public static void main(String[] args) {

		DNode d1 = new DNode(6);
		DNode d2 = new DNode(4);
		DNode d3 = new DNode(2);
		DNode d4 = new DNode(5);
		DNode d5 = new DNode(1);
		DNode d6 = new DNode(3);
		DNode d7 = new DNode(7);
		DNode d8 = new DNode(9);
		DNode d9 = new DNode(8);
		
		d1.pre = d2;
		d1.next = d7;
		d2.pre = d3;
		d2.next = d4;
		d3.pre = d5;
		d3.next = d6;
		d7.next = d8;
		d8.pre = d9;
		
		Tree2DLink t = new Tree2DLink();
		DNode head = new DNode(0);
		t.convert(d1, head);
		
		
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public DNode convert(DNode tree, DNode head) {
		
		if (tree == null) {
			return null;
		}
		
		DNode left = convert(tree.pre, head);
		DNode right = convert(tree.next, head);
		
		DNode node = new DNode(tree.data);
		
		if (left != null) {
			DNode temp = left.next != null ? left.next : left;
			temp.next = node;
			node.pre = temp;
		}
		
		if (right != null) {
			DNode temp = right.pre != null ? right.pre : right;
			node.next = temp;
			temp.pre = node;
		}
		
		if (left == null && right == null && head.next == null) {
			head.next = node;
		}
		return node;
	}
	
}
