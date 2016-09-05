package com.demo;

/**
 * 查找两个单向链表的公共节点，链表有可能是循环的
 * 
 * 这里分三种情况考虑
 * 1. 两个链表都是循环链表，都是循环链表的情况下判断循环链表的入口是否相同，如果有相同入口。
 * 2. 如果一个是循环链表，一个不是，那么不可能有相同节点
 * 3. 如果两个都不是循环链表，则按照普通的方式找共同点
 * @author kexun
 *
 */
public class LoopNode {

	public static void main(String[] args) {

		Node n1 = new LoopNode().new Node(1);
		Node n2 = new LoopNode().new Node(2);
		Node n3 = new LoopNode().new Node(3);
		Node n4 = new LoopNode().new Node(4);
		Node n5 = new LoopNode().new Node(5);
		Node n6 = new LoopNode().new Node(6);
		Node n7 = new LoopNode().new Node(7);
		Node n8 = new LoopNode().new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n4;
		
		Node f = new LoopNode().new Node(90);
		Node f2 = new LoopNode().new Node(91);
		Node f3 = new LoopNode().new Node(92);
		Node f4 = new LoopNode().new Node(93);
		Node f5 = new LoopNode().new Node(94);
		Node f6 = new LoopNode().new Node(95);
		Node f7 = new LoopNode().new Node(96);
		f.next = f2;
		f2.next = f3;
		f3.next = f4;
		f4.next = f5;
		f5.next = f6;
		f6.next = f7;
		f7.next = n6;
		
		
		LoopNode l = new LoopNode();
		Node com = l.findCommNode(n1, f);
		if (com != null) {
			System.out.println(com.data);
		} else {
			System.out.println("没有共同点");
		}
		
	}
	
	public Node findCommNode(Node n1, Node n2) {
		
		if (n1 == null || n2 == null) {
			return null;
		}
		
		Node loop1 = getFirstLoopNode(n1);
		Node loop2 = getFirstLoopNode(n2);
		
		if (loop1 == null && loop2 == null) {
			return findCommNodeInList(n1, loop1, n2, loop2);
		} else if (loop1 != null && loop2 != null) {
			if (loop1 != loop2) {
				if (isIntersect(loop1, loop2)) {
					return loop1;
				}
				return null;
			} else {
				return findCommNodeInList(n1, loop1, n2, loop2);
			}
		}
		
		return null;
	}
	
	/**
	 * 有两个环，但是各自的入口不同，需要判断这两个环是否是同一个环，如果在遍历过程中，两个节点
	 * 相遇，则说明是同一个环，否则就不是同一个环。
	 * @param loop1
	 * @param loop2
	 * @return
	 */
	public boolean isIntersect(Node loop1, Node loop2) {
		
		boolean intersect = false;
		
		while (loop1.next != loop1) {
			loop1 = loop1.next;
			if (loop1 == loop2) {
				intersect = true;
				break;
			}
		}
		
		return intersect;
	}
	
	/**
	 * 判断是否是循环链表，如果是，找到循环的入口。
	 * @param head
	 * @return
	 */
	public Node getFirstLoopNode(Node head) {
		
		Node step1 = head;
		Node step2 = head.next;
		
		Node first = null;
		while (step2 != null && step2.next != null) {
			
			if (step1 == step2) {
				first = step1;
				break;
			}
			
			step1 = step1.next;
			step2 = step2.next.next;
		}
		
		if (first != null) {
			first = head;
			step1 = step1.next;
			while (first != step1) {
				first = first.next;
				step1 = step1.next;
			}
		}
		
		return first;
	}
	
	/**
	 * 普通的单向链表中，查找共同点。
	 * @param n1
	 * @param s1
	 * @param n2
	 * @param s2
	 * @return
	 */
	public Node findCommNodeInList(Node n1, Node s1, Node n2, Node s2) {

		
		int len1 = 0;
		Node c1 = n1;
		while (c1 != s1) {
			len1++;
			c1 = c1.next;
		}
		
		int len2 = 0;
		Node c2 = n2;
		while (c2 != s2) {
			len2++;
			c2 = c2.next;
		}
		
		int d = len2 - len1;
		
		c1 = n1;
		c2 = n2;
		if (d < 0) {
			while (d++ != 0) {
				c1 = c1.next;
			}
		} else if (d > 0) {
			while (d-- != 0) {
				c2 = c2.next;
			}
		}
		
		Node comm = null;
		while (c1 != null && c1 != c2) {
			c1 = c1.next;
			c2 = c2.next;
		}
		
		if (c1 == c2) {
			comm = c1;
		}
		return comm;
	
	}
	
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	

}
