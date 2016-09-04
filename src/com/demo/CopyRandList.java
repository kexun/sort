package com.demo;

/**
 * 复制含有随机指针节点的链表
 * 方法：a->a`->b->b`->c->c`
 * @author kexun
 *
 */
public class CopyRandList {

	public static void main(String[] args) {

		Node n1 = new CopyRandList().new Node(1);
		Node n2 = new CopyRandList().new Node(2);
		Node n3 = new CopyRandList().new Node(3);
		Node n4 = new CopyRandList().new Node(4);
		Node n5 = new CopyRandList().new Node(5);
		Node n6 = new CopyRandList().new Node(6);
		Node n7 = new CopyRandList().new Node(7);
		Node n8 = new CopyRandList().new Node(8);
		
		n1.next = n2;
		n1.rand = n3;
		n2.next = n3;
		n2.rand = n1;
		n3.next = n4;
		n3.rand = n7;
		n4.next = n5;
		n5.next = n6;
		n5.rand = n7;
		n6.next = n7;
		n6.rand = n2;
		n7.next = n8;
		
		CopyRandList c = new CopyRandList();
		Node head = c.copyRandList(n1);
		
		while (head != null) {
			System.out.println(head.data);
			if (head.rand != null) {
				System.out.println("rand  : "+head.rand.data);
			} else {
				System.out.println("null");
			}
			
			head = head.next;
		}
		
	}

	public Node copyRandList(Node head) {
		
		
		if (head == null) {
			return null;
		}
		
		Node curr = head;
		while (curr != null) {
			Node temp = new Node(curr.data);
			temp.next = curr.next;
			curr.next = temp;
			curr = temp.next;
		}
		
		curr = head;
		while (curr != null) {
			Node temp = curr.next;
			temp.rand = curr.rand == null ? null : curr.rand.next;
			curr = temp.next;
		}
		
		Node newHead = head.next;
		curr = head;
		Node newCurr = newHead;
		while (curr != null) {
			curr.next = newCurr.next;
			newCurr.next = newCurr.next == null ? null : newCurr.next.next;
			curr = curr.next;
			newCurr = newCurr.next;
		}
		
		return newHead;
	}
	
	class Node {
		public int data;
		public Node next;
		public Node rand;
		public Node(int data) {
			this.data = data;
		}
	}
}