package com.demo;

public class CommonNodeInList {

	public static void main(String[] args) {

		Node a1 =new CommonNodeInList(). new Node(1);
		Node a2 =new CommonNodeInList(). new Node(2);
		Node a3 =new CommonNodeInList(). new Node(3);
		Node a4 =new CommonNodeInList(). new Node(4);
		Node a5 =new CommonNodeInList(). new Node(5);
		Node a6 =new CommonNodeInList(). new Node(6);
		Node a7 =new CommonNodeInList(). new Node(7);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		
		Node b1 =new CommonNodeInList(). new Node(8);
		Node b2 =new CommonNodeInList(). new Node(9);
		Node b3 =new CommonNodeInList(). new Node(11);
		Node b4 =new CommonNodeInList(). new Node(12);
		
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = a2;
		
		CommonNodeInList c = new CommonNodeInList();
		c.reverse(a1, b1);
	}
	
	public Node reverse(Node node1, Node node2) {
		
		if (node1.next == null && node2.next == null) {
			if (node1 == node2) {
				System.out.println(node1.data);
				return node1;
			}
			return null;
		} else if (node1.next == null && node2.next !=null) {
			 Node temp = reverse(node1, node2.next);
			 if (node1 == temp) {
				 System.out.println(node1.data);
			 }
			 return temp;
		} else if (node1.next != null && node2.next == null) {
			reverse(node1, node2.next);
		} else {
			reverse(node1.next, node2.next);
		}
		return null;
		
	}

	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
}
