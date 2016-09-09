package com.demo;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * 此题的解法和上一题类似。
 * 首先后续遍历二叉树，其中保存每颗树的最大值和最小值，已经符合搜索二叉树条件的节点个数。
 * 当遍历到某个节点时，发现条件不符合，则将size大小调整为1。 当前结点下的size = lsize + rsize
 * @author kexun
 *
 */
public class MaxSearchTreeSize {

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
		h10.right = h15;
		h4.left = h16;
		
		MaxSearchTreeSize m = new MaxSearchTreeSize();
		int[] record = new int[3];
		m.maxSize(head, record);
		System.out.println(record[0]);
	
		
	}

	public void maxSize(Tree head, int[] array) {
		
		if (head == null) {
			array[0] = 0;
			array[1] = Integer.MAX_VALUE;
			array[2] = Integer.MIN_VALUE;
			return;
		}
		
		int data = head.data;
		Tree left = head.left;
		Tree right = head.right;
		
		maxSize(head.left, array);
		int lsize = array[0];
		int lmin = array[1];
		int lmax = array[2];
		
		maxSize(head.right, array);
		int rsize = array[0];
		int rmin = array[1];
		int rmax = array[2];
		
		array[1] = Math.min(lmin, data);
		array[2] = Math.max(rmax, data);
		
		int size = 1;
		if (lmax < data) {
			size += lsize;
		} else if (left != null && left.data < data) {
			size++;
		}
		
		if (rmax > data) {
			size += rsize;
		} else if (right != null && right.data > data) {
			size++;
		}
		
		array[0] = size;
	}
	
	
}
