package com.demo;

import java.util.Stack;

/**
 * 调整搜索二叉树中的两个错误节点
 * @author kexun
 *
 */
public class TwoErrNode {

	public static void main(String[] args) {

		Tree head = new Tree(70);
		Tree h1 = new Tree(40);
		Tree h2 = new Tree(50);
		Tree h3 = new Tree(20);
		Tree h4 = new Tree(100);
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
		
		TwoErrNode t = new TwoErrNode();
		Tree[] tree = t.getTwoErrNode2(head);
		System.out.println("-------------");
		for (Tree a : tree) {
			if (a != null) {
				System.out.println(a.data);
			}
		}
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
	public Tree[] getTwoErrNode2(Tree head) {
		
		Tree[] nodes = new Tree[2];
		Stack<Tree> stack = new Stack<Tree>();
		Tree pre = null;
		while (!stack.isEmpty() || head != null) {
			
			if (head != null) {
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
	
	
	
	
}
