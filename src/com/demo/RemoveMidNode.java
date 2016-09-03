package com.demo;

/**
 * 删除单向链表中间节点
 * @author kexun
 *
 */
public class RemoveMidNode {

	public static void main(String[] args) {

		System.out.println(Math.ceil((double)(5*7)/(double)6));
		Node n1 = new RemoveMidNode().new Node(1);
		Node n2 = new RemoveMidNode().new Node(2);
		Node n3 = new RemoveMidNode().new Node(3);
		Node n4 = new RemoveMidNode().new Node(4);
		Node n5 = new RemoveMidNode().new Node(5);
		Node n6 = new RemoveMidNode().new Node(6);
		Node n7 = new RemoveMidNode().new Node(7);
		Node n8 = new RemoveMidNode().new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		RemoveMidNode r = new RemoveMidNode();
		Node h = r.removeMidNode(n1);
		while (h != null) {
			System.out.println(h.data);
			h = h.next;
		}
		
	}
	
	public Node removeMidNode(Node head) {
	
		if (head == null || head.next == null) {
			return null;
		}
		
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
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
