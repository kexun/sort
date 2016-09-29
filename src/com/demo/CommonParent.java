package com.demo;


/**
 * 查找两个节点的最近公共祖先
 * @author kexun
 *
 */
public class CommonParent {

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
		
		CommonParent c = new CommonParent();
		boolean[] flag = new boolean[1];
		Tree node = c.getCommonNode(head, h9, h3, flag);
		System.out.println(node.data);
	}

	/**
	 * 通过后续遍历的方式，获取到两个共同的祖先
	 * @param head
	 * @param n1
	 * @param n2
	 * @param flag
	 * @return
	 */
	public Tree getCommonNode(Tree head, Tree n1, Tree n2, boolean[] flag) {
		
		if (head == null) {
			flag[0] = false;
			return null;
		}

		Tree l = getCommonNode(head.left, n1, n2, flag);
		boolean f1 = flag[0];
		Tree r = getCommonNode(head.right, n1, n2, flag);
		boolean f2 = flag[0];
		
		if (l != null || r != null) {
			return l == null ? r : l;
		}
		
		if (f1 && f2) {
			return head;
		} else if (f1 || f2) {
			flag[0] = f1 || f2;
			if (head == n1 || head == n2) {
				return head;
			}
		} else {
			if (head == n1 || head == n2) {
				flag[0] = true;
			}
		}
		
		return null;
	}
	
}
