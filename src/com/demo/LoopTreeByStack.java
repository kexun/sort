package com.demo;

import java.util.Stack;

/**
 * 非递归的方式遍历二叉树，先序，中序，后续。利用栈。
 * @author kexun
 *
 */
public class LoopTreeByStack {

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
		
		LoopTreeByStack l = new LoopTreeByStack();
//		l.preOrder(head);
//		l.inOrder(head);
		l.afterOrder(head);
	}
	
	/**
	 * 先序
	 * @param head
	 */
	public void preOrder(Tree head) {
		
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Tree tree = stack.pop();
			if (tree.right != null) {
				stack.push(tree.right);
			}
			
			if (tree.left != null) {
				stack.push(tree.left);
			}
			
			System.out.println(tree.data);
		}
	}
	
	/**
	 * 中序
	 * @param head
	 */
	public void inOrder(Tree head) {
		
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(head);
		
		while (!stack.isEmpty()) {
			Tree tree = stack.pop();
			
			if (tree.left == null && tree.right == null) {
				System.out.println(tree.data);
			} else {
				if (tree.right != null) {
					stack.push(tree.right);
					tree.right = null;
				}
				
				stack.push(tree);
				
				if (tree.left != null) {
					stack.push(tree.left);
					tree.left = null;
				}
			}
			
			
		}
	}
	
	public void afterOrder(Tree head) {
		
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(head);
		
		while (!stack.isEmpty()) {
			Tree tree = stack.pop();
			
			if (tree.left == null && tree.right == null) {
				System.out.println(tree.data);
			} else {
				stack.push(tree);
				if (tree.right != null) {
					stack.push(tree.right);
					tree.right = null;
				}
				
				
				if (tree.left != null) {
					stack.push(tree.left);
					tree.left = null;
				}
			}
			
			
		}
	}

}
