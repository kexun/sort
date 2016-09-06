package com.demo;

/**
 * 按照左右半区的方式重新组合链表
 * 
 * 首先将链表分成等分成两部分，然后两部分链表交叉合并。
 * 如： 1，2，3，4，5 -> 1,3,2,,4,5
 * @author kexun
 *
 */
public class AdjustLeftRightLink {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		
		AdjustLeftRightLink a = new AdjustLeftRightLink();
		a.adjustLink(n1);
		
		while (n1 != null) {
			System.out.println(n1.data);
			n1 = n1.next;
		}
		
	}

	
	public void adjustLink(Node node) {
		
		if (node == null || node.next == null) {
			return;
		}
		
		Node head = new Node(0);
		head.next = node;
		
		Node pre = head;
		Node next = head;
		while (next.next != null && next.next.next != null) {
			pre = pre.next;
			next = next.next.next;
		}
		
		Node mid = pre.next;
		pre.next = null;
		Node curr = head.next;
		while (curr != null) {
			Node midTemp = mid.next;
			Node currTemp = curr.next;
			if (midTemp != null && currTemp != null) {
				mid.next = currTemp;
			}
			curr.next = mid;
			curr = currTemp;
			mid = midTemp;
		}
		
	}
	
}
