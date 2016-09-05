package com.demo;

/**
 * 单链表的选择排序
 * 
 * 从头开始遍历链表，每次遍历的时候，先指定第一个节点的值为min，
 * 然后逐个遍历节点，发现比min小的节点，则将次节点调整到第一个节点。
 * 注意在调整节点的过程中，保持链表的连续性。
 * @author kexun
 *
 */
public class SelectionSort {

	public static void main(String[] args) {

		Node n1 = new Node(0);
		Node n2 = new Node(2);
		Node n3 = new Node(5);
		Node n4 = new Node(4);
		Node n5 = new Node(8);
		Node n6 = new Node(6);
		Node n7 = new Node(17);
		Node n8 = new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		
		SelectionSort s = new SelectionSort();
		s.selectionSort(n1);
		
		while (n1 != null) {
			System.out.println(n1.data);
			n1 = n1.next;
		}
	}

	public void selectionSort(Node head) {

		if (head == null || head.next == null) {
			return;
		}
		
		Node pre = head;
		Node curr = null;
		Node next = null;
		while (pre.next != null) {
			curr = pre.next;
			int min = curr.data;
			while (curr.next != null) {
				next = curr.next;
				if (next.data <= min) {
					min = next.data;
					curr.next = next.next;
					next.next = pre.next;
					pre.next = next;
				} else {
					curr = curr.next;
				}
			}
			pre = pre.next;
		}
		
	}
	
}
