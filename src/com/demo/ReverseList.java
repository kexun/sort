package com.demo;

/**
 * 反转单向或双向链表
 * @author kexun
 *
 */
public class ReverseList {

	public static void main(String[] args) {

		Node n1 = new ReverseList().new Node(1);
		Node n2 = new ReverseList().new Node(2);
		Node n3 = new ReverseList().new Node(3);
		Node n4 = new ReverseList().new Node(4);
		Node n5 = new ReverseList().new Node(5);
		Node n6 = new ReverseList().new Node(6);
		Node n7 = new ReverseList().new Node(7);
		Node n8 = new ReverseList().new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		ReverseList r = new ReverseList();
		Node n = r.reverseListFromTo(n1, 1, 9);
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
	}
	
	/**
	 * 反转单向链表
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head) {
		
		if (head == null) {
			return head;
		}
		
		Node pre = null;
		Node curr = null;
		while (head != null) {
			curr = head.next;
			head.next = pre;
			pre = head;
			head = curr;
		}
		
		return pre;
	}

	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	class DNode {
		int data;
		DNode next;
		DNode pre;
		public DNode(int data) {
			this.data = data;
		}
	}
	
	public DNode reverseDlist(DNode head) {
		
		if (head == null) {
			return null;
		}
		
		DNode pre = null;
		DNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;
		}
		
		return pre;
	}
	
	/**
	 * 反转部分单向链表
	 * @param head
	 * @param from
	 * @param to
	 * @return
	 */
	public Node reverseListFromTo(Node head, int from, int to) {
		
		Node curr = head;
		Node pre = null;
		Node next = null;
		int index = 1;
		Node tempPre = null;
		Node tempCur = null;
		while (index < from) {
			index++;
			next = curr.next;
			pre = curr;
			curr = next;
		}
		tempPre = pre;
		if (pre == null) {
			tempCur = curr;
		} else {
			tempCur = pre.next;
		}
		while (index <= to && curr != null) {
			index++;
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		
		tempCur.next = curr;
		if (tempPre == null) {
			return pre;
		} else {
			tempPre.next = pre;
			return head;
		}
		
	}
}
