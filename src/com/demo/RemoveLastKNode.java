package com.demo;

/**
 * 单链表中删除倒数第k个元素
 * @author kexun
 *
 */
public class RemoveLastKNode {

	public static void main(String[] args) {

		Node n1 = new RemoveLastKNode().new Node(1);
		Node n2 = new RemoveLastKNode().new Node(2);
		Node n3 = new RemoveLastKNode().new Node(3);
		Node n4 = new RemoveLastKNode().new Node(4);
		Node n5 = new RemoveLastKNode().new Node(5);
		Node n6 = new RemoveLastKNode().new Node(6);
		Node n7 = new RemoveLastKNode().new Node(7);
		Node n8 = new RemoveLastKNode().new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		RemoveLastKNode r = new RemoveLastKNode();
		Node head = r.removeLastKNode(n1, 4);
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}

	public Node removeLastKNode(Node head, int k) {
		
		if (k <= 0) {
			return head;
		}
		
		if (head == null) {
			return null;
		}
		
		Node curr = head;
		while (curr.next != null) {
			k--;
			curr = curr.next;
		}
		
		if (k > 1) {
			return head;
		}
		
		if (k == 1) {
			return head.next;
		}
		
		curr = head;
		while (k < 0) {
			k++;
			curr = curr.next;
		}
		curr.next = curr.next.next;
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
