package com.demo;

import java.util.LinkedList;

/**
 * 二叉树按层打印和zigzag打印
 * @author kexun
 *
 */
public class TreeLayerZigZagPrint {

	public static void main(String[] args) {


		Tree head = new Tree(6);
		Tree h1 = new Tree(1);
		Tree h2 = new Tree(12);
		Tree h3 = new Tree(0);
		Tree h4 = new Tree(3);
		Tree h5 = new Tree(10);
		Tree h6 = new Tree(13);
		Tree h7 = new Tree(4);
		Tree h8 = new Tree(14);
		Tree h9 = new Tree(20);
		Tree h10 = new Tree(16);
		Tree h11 = new Tree(2);
		Tree h12 = new Tree(5);
		Tree h13 = new Tree(11);
		Tree h14 = new Tree(15);
		Tree h15 = new Tree(17);
		Tree h16 = new Tree(2);
		
		head.left = h1;
		head.right = h2;
		h1.left = h3;
		h1.right = h4;
		h2.left = h5;
		h2.right = h6;
		h5.left = h7;
		h5.right = h8;
		h6.left = h9;
		h6.right = h10;
		h7.left = h11;
		h7.right = h12;
		h8.left = h13;
		h8.right = h14;
		
		TreeLayerZigZagPrint t = new TreeLayerZigZagPrint();
		t.layerPrint(head);
		System.out.println();
		t.zigzagPring(head);
	}

	/**
	 * 从左到又 一层一层打印二叉树  利用广度优先算法
	 * @param head
	 */
	public void layerPrint(Tree head) {
		
		if (head == null) {
			return;
		}
		LinkedList<Tree> q = new LinkedList<Tree>();
		
		q.add(head);
		while (!q.isEmpty()) {
			
			Tree node = q.pollFirst();
			System.out.print(node.data+",");
			if (node.left != null) {
				q.add(node.left);
			}
			
			if (node.right != null) {
				q.add(node.right);
			}
		}
		
	}
	
	/**
	 * zigzag方式打印二叉树
	 * @param head
	 */
	public void zigzagPring(Tree head) {
		
		if (head == null) {
			return;
		}
		LinkedList<Tree> q = new LinkedList<Tree>();
		q.offerFirst(head);
		boolean flag = true;
		Tree last = head;
		Tree nextLast = null;
		int level = 1;
		printLevelAndOrientation(level++, flag);
		
		while (!q.isEmpty()) {
			
			if (flag) {
				head = q.pollFirst();
				if (head.left != null) {
					q.offerLast(head.left);
					nextLast = nextLast == null ? head.left : nextLast;
				}
				
				if (head.right != null) {
					q.offerLast(head.right);
					nextLast = nextLast == null ? head.right : nextLast;
				}
			} else {
				head = q.pollLast();
				if (head.right != null) {
					q.offerFirst(head.right);
					nextLast = nextLast == null ? head.right : nextLast;
				}
				
				if (head.left != null) {
					q.offerFirst(head.left);
					nextLast = nextLast == null ? head.left : nextLast;
				}
			}
			
			System.out.print(head.data + " ");
			if (head == last && !q.isEmpty()) {
				last = nextLast;
				flag = !flag;
				nextLast = null;
				System.out.println();
				printLevelAndOrientation(level++, flag);
			}
		}
	}

	private void printLevelAndOrientation(int i, boolean flag) {

		System.out.print("level = " + i+" ");
		System.out.println(flag?"from left to right" : "from right to left");
	}
	
}
