package com.demo;

/**
 * 树t1,t2 判断t1是否包含t2
 * @author kexun
 *
 */
public class ContainsTree {

	public static void main(String[] args) {

		Tree h1 = new Tree(1);
		Tree a1 = new Tree(2);
		Tree a2 = new Tree(3);
		Tree a3 = new Tree(4);
		Tree a4 = new Tree(5);
		Tree a5 = new Tree(6);
		Tree a6 = new Tree(7);
		Tree a7 = new Tree(8);
		Tree a8 = new Tree(9);
		Tree a9 = new Tree(10);

		h1.left = a1;
		h1.right = a2;
		a1.left = a3;
		a1.right = a4;
		a2.left = a5;
		a2.right = a6;
		a3.left = a7;
		a3.right = a8;
		a4.left = a9;
		
		Tree h2 = new Tree(2);
		Tree b1 = new Tree(4);
		Tree b2 = new Tree(5);
		Tree b3 = new Tree(8);
		
		h2.left = b1;
		h2.right = b2;
		b1.left = b3;
		
		ContainsTree c = new ContainsTree();
		boolean re = c.contains(h1, h2);
		System.out.println(re);
	}
	
	public boolean contains(Tree t1, Tree t2) {
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}
	
	public boolean check(Tree t1, Tree t2) {
		if (t2 == null) {
			return true;
		}
		
		if (t1 == null || t1.data != t2.data) {
			return false;
		}
		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}

}
