package com.demo;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author kexun
 *
 */
public class SortList {

	public static void main(String[] args) {

		ListNode head = new SortList().new ListNode(0);
		ListNode a = new SortList().new ListNode(9);
		ListNode b = new SortList().new ListNode(3);
		ListNode c = new SortList().new ListNode(0);
		ListNode d = new SortList().new ListNode(1);
		
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;

		SortList s = new SortList();
		ListNode ne = s.sortList(head);
		while (ne != null) {
			System.out.println(ne.val);
			ne = ne.next;
		}
	}
	
	public ListNode sortList(ListNode head) {
    
		
		if (head == null) {
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		
		ListNode newHead = new ListNode(0);
		newHead.next = new ListNode(head.next.val);
		ListNode curr = head.next.next;
		while (curr != null) {
			
			ListNode newPre = newHead;
			ListNode newCurr = newHead.next;
			while (newCurr != null) {
				
				if (newCurr.val > curr.val) {
					newPre.next = new ListNode(curr.val);
					newPre.next.next = newCurr;
					break;
				} else {
					newPre = newPre.next;
					newCurr = newCurr.next;
				}
			}
			if (newCurr == null) {
				newPre.next = new ListNode(curr.val);
			}
			curr = curr.next;
			
		}
		
		return newHead;
    }
	
	class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) {
	      val = x;
	      next = null;
	  }
	}

}
