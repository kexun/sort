package com.demo;

/**
 * 在二叉树中找到一个节点的后继节点
 * @author kexun
 *
 */
public class NextTreeNode {

	public static void main(String[] args) {
		Tree n1 = new Tree(1);
		Tree n2 = new Tree(2);
		Tree n3 = new Tree(3);
		Tree n4 = new Tree(4);
		Tree n5 = new Tree(5);
		Tree n6 = new Tree(6);
		Tree n7 = new Tree(7);
		Tree n8 = new Tree(8);
		Tree n9 = new Tree(9);
		Tree n10 = new Tree(10);
		
		n6.left = n3;
		n3.parent = n6;
		n6.right = n9;
		n9.parent = n6;
		n3.left = n1;
		n1.parent = n3;
		n3.right = n4;
		n4.parent = n3;
		n1.right = n2;
		n2.parent = n1;
		n4.right = n5;
		n5.parent = n4;
		n9.left = n8;
		n8.parent = n9;
		n8.left = n7;
		n7.parent = n8;
		n9.right = n10;
		n10.parent = n9;
		
		NextTreeNode n = new NextTreeNode();
		Tree node = n.getNextTree(n9);
		System.out.println(node.data);
	}

	public Tree getNextTree(Tree node) {
		
		if (node.right != null) {
			return node.right;
		}
		
		Tree pre = node.parent;
		
		while (pre != null && pre.left != node) {
			node = pre;
			pre = pre.parent;
		}
		
		return pre;
	}
}
