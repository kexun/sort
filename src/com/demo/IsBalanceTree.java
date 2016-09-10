package com.demo;

public class IsBalanceTree {

	public static void main(String[] args) {

		Tree head = new Tree(40);
		Tree h1 = new Tree(70);
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
		
		IsBalanceTree i= new IsBalanceTree();
		boolean[] is = new boolean[1];
		int high = i.getLevel(head, is);
		System.out.println(high);
		System.out.println(is[0]);
	}

	public int getLevel(Tree head, boolean[] is) {
		
		if (head == null) {
			is[0] = true;
			return 0;
		}
		
		int le = getLevel(head.left, is) + 1;
		if (!is[0]) {
			return le;
		}
		
		int r = getLevel(head.right, is) + 1;
		if (!is[0]) {
			return r;
		}
		
		int index = Math.abs(le - r);
		if (index > 1) {
			is[0] = false;
		}
		
		return Math.max(le, r);
	}
}
