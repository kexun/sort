package com.demo;

import java.util.Stack;

/**
 * 两个链表生成相加链表，利用两个辅助栈相加
 * @author kexun
 *
 */
public class AddList {

	public static void main(String[] args) {

		Node n1 = new AddList().new Node(1);
		Node n2 = new AddList().new Node(2);
		Node n3 = new AddList().new Node(3);
		Node n4 = new AddList().new Node(4);
		Node n5 = new AddList().new Node(5);
		Node n6 = new AddList().new Node(9);
		Node n7 = new AddList().new Node(7);
		Node n8 = new AddList().new Node(9);
		
//		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		AddList a = new AddList();
		Node head = a.addList(n1, n2);
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public Node addList(Node n1, Node n2) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		while (n1 != null) {
			s1.push(n1.data);
			n1 = n1.next;
		}
		
		while (n2 != null) {
			s2.push(n2.data);
			n2 = n2.next;
		}

		Node head = null;
		int ca = 0;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			int temp = s1.pop() + s2.pop() + ca;
			Node node = new Node(temp%10);
			node.next = head;
			ca = temp / 10;
			head = node;
		}
		
		while (!s1.isEmpty()) {
			int temp = s1.pop() + ca;
			Node node = new Node(temp%10);
			node.next = head;
			head = node;
			ca = temp / 10;
		}
		
		while (!s2.isEmpty()) {
			int temp = s2.pop() + ca;
			Node node = new Node(temp%10);
			node.next = head;
			head = node;
			ca = temp / 10;
		}
		
		return head;
	}
	
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
}
