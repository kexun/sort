package com.demo;


/**
 * 给定一个值m，将链表划分成三部分，左边小于m,中间等于m, 右边大于m,同时要保持链表原有顺序
 * 
 * 做法是指定一个中间节点，遍历链表，如果发现节点小于等于m，则把节点调整为mid的父节点。否则遍历下一个节点。
 * @author kexun
 *
 */
public class AdjustList {

	public static void main(String[] args) {

		Node n1 = new AdjustList().new Node(3);
		Node n2 = new AdjustList().new Node(2);
		Node n3 = new AdjustList().new Node(3);
		Node n4 = new AdjustList().new Node(3);
		Node n5 = new AdjustList().new Node(3);
		Node n6 = new AdjustList().new Node(0);
		Node n7 = new AdjustList().new Node(7);
		Node n8 = new AdjustList().new Node(3);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		AdjustList a = new AdjustList();
		
		Node head = a.adjust(n1, 3);
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}

	public Node adjust(Node node, int m) {
		
		
		if (node == null || node.next == null) {
			return node;
		}
		
		Node head = new Node(0);
		head.next = node;
		Node curr = head.next;
		Node mid = head;
		Node pre;
		while (curr.next != null) {
			
			pre = curr;
			curr = curr.next;
			if (mid.next.data < m) {
				mid = mid.next;
			} else if (curr.data <= m) {
				pre.next = curr.next;
				curr.next = mid.next;
				mid.next = curr;
				if (curr.data != m) {
					mid = curr;
				}
				curr = pre;
			}
		}
		
		return head.next;
	}
	
	
	
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
}
