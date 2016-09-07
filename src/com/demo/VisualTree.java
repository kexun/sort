package com.demo;

/**
 * 用一种直观的方式打印二叉树
 * @author kexun
 *
 */
public class VisualTree {

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
	
		VisualTree v = new VisualTree();
		v.pringVisualTree(head);
		
	}

	public void pringVisualTree(Tree head) {
		
		if (head == null) {
			return;
		}
		
		revert(head, 0, "H", 17);
	}
	
	public void revert(Tree head, int h, String to, int len) {
		
		if (head == null) {
			return;
		}
		
		revert(head.right, h+1, "v", len);
		
		String data = to+head.data+to;
		int lenM = data.length();
		int lenl = (len - lenM) / 2;
		int lenr = len - lenM - lenl;
		data = getSpace(lenl) + data + getSpace(lenr);
		System.out.println(getSpace(h * len) + data);
		revert(head.left, h+1, "^", len);
	}

	private String getSpace(int len) {
		String res = "";
		while (len-- != 0) {
			res += " ";
		}
		return res;
	}
	
}
