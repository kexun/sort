package com.demo;

import java.util.HashMap;
import java.util.Stack;

/**
 * 调整搜索二叉树中的两个错误节点
 * @author kexun
 *
 */
public class TwoErrNode {

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
		
		HashMap<Tree, Tree> errs = new HashMap<Tree, Tree>();
		TwoErrNode t = new TwoErrNode();
		Tree[] tree = t.getTwoErrNode2(head, errs);
		System.out.println("-------------");
		for (Tree a : tree) {
			if (a != null) {
				System.out.println(a.data);
			}
		}
		
		Tree t01 = tree[0];
		Tree t02 = tree[1];
		Tree[] p = t.getErrParents(errs, t01, t02);
		System.out.println("-------------");
		System.out.println(p[0] == null? "head" : p[0].data);
		System.out.println(p[1] == null? "head" : p[1].data);
		Tree newTree = t.changeTwoNode(head, p, tree);
		t.getTwoErrNode2(newTree, errs);
	}

	/**
	 * 利用stack中序遍历二叉树 第一种方法
	 * @param head
	 * @return
	 */
	public Tree[] getTwoErrNode(Tree head) {
		
		if (head == null) {
			return null;
		}

		Tree[] nodes = new Tree[2];
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(head);
		
		while (!stack.isEmpty()) {
			Tree node = stack.peek();
			if (node.left == null && node.right == null) {
				stack.pop();
				System.out.println(node.data);
			} else if (node.left != null) {
				stack.push(node.left);
				node.left = null;
			} else if (node.right != null) {
				stack.pop();
				stack.push(node.right);
				System.out.println(node.data);
			}
		}
		
		return nodes;
	}
	
	/**
	 * 利用stack中序遍历二叉树，因此搜索二叉树的节点是依次从小到大排列的，
	 * 如果有两个节点是对调的，一定会出现降序的情况，这是只有记录下这两个降序
	 * 的节点即可。
	 * @param head
	 * @return
	 */
	public Tree[] getTwoErrNode2(Tree head, HashMap<Tree, Tree> errs) {
		
		Tree[] nodes = new Tree[2];
		Stack<Tree> stack = new Stack<Tree>();
		Tree pre = null;
		while (!stack.isEmpty() || head != null) {
			
			if (head != null) {
				if (head.left != null) {
					errs.put(head.left, head);
				}
				if (head.right != null) {
					errs.put(head.right, head);
				}
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if (pre != null && pre.data > head.data) {
					nodes[0] = nodes[0] == null ? pre : nodes[0];
					nodes[1] = head;
				}
				System.out.println(head.data);
				pre = head;
				head = head.right;
			}
		}
		
		return nodes;
	}
	
	public Tree[] getErrParents(HashMap<Tree, Tree> errs, Tree n1, Tree n2) {
		
		Tree[] p = new Tree[2];
		
		p[0] = errs.get(n1);
		p[1] = errs.get(n2);
		
		return p;
	}
	
	/**
	 * 二叉树交换两个节点，并不是简单的调整内容，而是改变两个节点的指向
	 * @param head
	 * @param p
	 * @param er
	 * @return
	 */
	public Tree changeTwoNode(Tree head, Tree[] p, Tree[] er) {
		
		Tree t01 = er[0];
		Tree t02 = er[1];
		Tree e1 = p[0];
		Tree e2 = p[1];
		System.out.println("-------------");
		
		Tree node1 = t01.left;
		Tree node2 = t01.right;
		Tree node3 = t02.left;
		Tree node4 = t02.right;
		
		t01.left = node3 == t01? t02 : node3;
		t01.right = node4 == t01? t02 : node4;
		t02.left = node1 == t02? t01 : node1;
		t02.right = node2 == t02? t01 : node2;

		if (e1 == null) {
			head = t02;
		}
		
		if (e2 == null) {
			head = t01;
		}
		
		return head;
	}
}
