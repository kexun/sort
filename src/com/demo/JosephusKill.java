package com.demo;

/**
 * 约瑟夫问题，n个人围成一个圈，从1开始数到m的人被杀死，然后下一个从一开始数，
 * 数到m的人被杀死，这样循环往复，求最后一个生还的人是谁？
 * 1.最普通的方法，模拟一个环，然后逐个杀掉时间复杂度为O(m*n)
 * 2.用递归的方式，求出N(i)和N(i-1)的关系，求出最后被杀的人的编号，时间复杂度O(n)
 * 公式 N(i) = (N(i-1) + m -1) % i + 1
 * N(i) 代表最后被杀的那个人的编号。 得到了这个编号以后，就可以遍历链表，获取到第N(i)个
 * @author kexun
 *
 */
public class JosephusKill {

	public static void main(String[] args) {

		Node n1 = new JosephusKill().new Node(1);
		Node n2 = new JosephusKill().new Node(2);
		Node n3 = new JosephusKill().new Node(3);
		Node n4 = new JosephusKill().new Node(4);
		Node n5 = new JosephusKill().new Node(5);
		Node n6 = new JosephusKill().new Node(6);
		Node n7 = new JosephusKill().new Node(7);
		Node n8 = new JosephusKill().new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;
		
		JosephusKill j = new JosephusKill();
		Node live = j.kill(n1, 3);
		System.out.println(live.data);
		
	}

	public Node kill(Node head, int m) {
		
		if (head == null) {
			return null;
		}
		
		Node curr = head;
		int i=1;
		while (curr.next != head) {
			i++;
			curr = curr.next;
		}
		
		int index = getLive(i, m);
		
		curr = head;
		while (--index != 0) {
			curr = curr.next;
		}
		return curr;
	}

	public int getLive(int i, int m) {
		
		if (i == 1) {
			return 1;
		}
		
		return (getLive(i-1, m)+m-1) % i + 1;
	}
	
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
}
