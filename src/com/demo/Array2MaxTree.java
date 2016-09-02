package com.demo;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的maxTree
 * MaxTree定义：
 * 1.数组没有重复数字
 * 2.MaxTree是一颗二叉树，每个节点对应数组的一个元素
 * 3.每一颗树上，最大的值都在头节点
 * @author kexun
 *
 */
public class Array2MaxTree {

	public static void main(String[] args) {

		int[] a = {
				5,7,1,6,4,8,9
		};
		Array2MaxTree m = new Array2MaxTree();
		Node tree = m.getMaxTree(a);
		System.out.println(tree.value);
		System.out.println(tree.left.value);
		System.out.println(tree.right.value);
		
	}
	
	class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public Node getMaxTree(int[] array) {
		
		int length = array.length;
		
		if (length == 0) {
			return null;
		}
		
		if (length == 1) {
			return new Node(array[0]);
		}
		
		Node[] nodes = new Node[length];
		for (int i=0; i<length; i++) {
			nodes[i] = new Node(array[i]);
		}
		
		Stack<Node> stack = new Stack<Node>();
		HashMap<Node, Node> lmap = new HashMap<Node, Node>();
		HashMap<Node, Node> rmap = new HashMap<Node, Node>();
		
		for (int i=0; i<length; i++) {
			Node currNode = nodes[i];
			while (!stack.isEmpty() && stack.peek().value < currNode.value) {
				popStack2Map(stack, lmap);
			}
			stack.push(currNode);
		}
		
		while (!stack.isEmpty()) {
			popStack2Map(stack, lmap);
		}
		
		for (int i=length-1; i>=0; i--) {
			Node currNode = nodes[i];
			while (!stack.isEmpty() && stack.peek().value < currNode.value) {
				popStack2Map(stack, rmap);
			}
			stack.push(currNode);
		}
		
		while (!stack.isEmpty()) {
			popStack2Map(stack, rmap);
		}
		
		Node head = null;
		for (int i=0; i<length; i++) {
			Node currNode = nodes[i];
			Node left = lmap.get(currNode);
			Node right = rmap.get(currNode);
			
			if (left == null && right == null) {
				head = currNode;
			} else if (left == null) {
				if (right.left == null) {
					right.left = currNode;
				} else {
					right.right = currNode;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = currNode;
				} else {
					left.right = currNode;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null) {
					parent.left = currNode;
				} else {
					parent.right = currNode;
				}
			}
		}
		
		return head;
	}

	public void popStack2Map(Stack<Node> stack, HashMap<Node, Node> lmap) {

		Node temp = stack.pop();
		if (stack.isEmpty()) {
			lmap.put(temp, null);
		} else {
			lmap.put(temp, stack.peek());
		}
	}

}
