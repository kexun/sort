package com.demo;

import java.util.Scanner;

/**
 * 二叉树节点间的最大距离
 * @author kexun
 *
 */
public class MaxTreeDist {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String st = in.nextLine();
			String[] line = st.split(" ");
			int a = Integer.valueOf(line[0]);
			int b = Integer.valueOf(line[1]);
			System.out.println(a+b);
		}
		
		
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
		
		int res = maxDist(head);
		System.out.println(res);
		
	}
	
	public static int maxDist(Tree head) {
		
		int[] record = {0};
		return posOrder(head, record);
	}
	
	public static int posOrder(Tree head, int[] record) {
		
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		
		int lMax = posOrder(head.left, record);
		int maxFromLeft = record[0];
		
		int rMax = posOrder(head.right, record);
		int maxFromRight = record[0];
		
		int curr = maxFromLeft + maxFromRight + 1;
		record[0] = Math.max(maxFromRight, maxFromLeft) + 1;
		return Math.max(Math.max(lMax, rMax), curr);
		
	}

}
