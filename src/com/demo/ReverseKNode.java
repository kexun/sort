package com.demo;

/**
 * 将链表的每k个节点之间逆序，有两种方法，第一种可以利用栈，第二种之间调整节点之间的关系。
 * @author kexun
 *
 */
public class ReverseKNode {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		ReverseKNode r = new ReverseKNode();
		Node node = r.method1(n1, 3);
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		
	}
	
	
	public Node method1(Node h, int k) {
		
		Node newHead = new Node(0);
		newHead.next = h;
		
		int index = 1;
		Node curr = h;
		Node next = null;
		Node pre = newHead;
		while (curr != null) {
			
			next = curr.next;
			if (index == k) {
				pre = resign(pre, pre.next, next);
				index = 0;
			}
			curr = next;
			index++;
		}
		
		return newHead.next;
	}
	
	/**
	 * 给定链表的起点和终点，对他逆序，同时要注意将上一段链表的末尾和当前新的链表的头部相连。
	 * @param pre
	 * @param start
	 * @param end
	 * @return
	 */
	public Node resign(Node pre, Node start, Node end) {
		
		Node left = end;
		Node curr = start;
		while (curr != end) {
			Node next = curr.next;
			curr.next = left;
			left = curr;
			curr = next;
		}
		Node temp = pre.next;
		pre.next = left;
		return temp;
	}
	

}
