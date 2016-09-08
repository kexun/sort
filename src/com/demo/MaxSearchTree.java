package com.demo;

/**
 * 找到二叉树中的最大搜索二叉树
 * 利用后续遍历的性质。
 * @author kexun
 *
 */
public class MaxSearchTree {

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

		MaxSearchTree m = new MaxSearchTree();
		int[] record = new int[3];
		Tree re = m.revert(head, record);
		System.out.println(re.data);
	}

	
	public Tree revert(Tree head, int[] record) {
		
		if (head == null) {
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return null;
		}
		
		int data = head.data;
		Tree left = head.left;
		Tree right = head.right;
		
		Tree lt = revert(left, record);
		int lsize = record[0];
		int lmin = record[1];
		int lmax = record[2];
		
		Tree rt = revert(right, record);
		int rsize = record[0];
		int rmin = record[1];
		int rmax = record[2];
		
		record[1] = Math.min(lmin, data);
		record[2] = Math.max(rmax, data);
		
		if (left == lt && right == rt && lmax < data && rmin > data) {
			record[0] = lsize + rsize + 1;
			return head;
		}
		record[0] = Math.max(lsize, rsize);
		return lsize > rsize ? lt : rt;
	}
}
