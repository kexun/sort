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
//		ListNode ne = s.sortList(head);
//		while (ne != null) {
//			System.out.println(ne.val);
//			ne = ne.next;
//		}
		s.sortList2(head);
	}
	
	public ListNode sortList(ListNode head) {
    
		
		if (head == null) {
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		
		ListNode newHead = new ListNode(0);
		newHead.next = new ListNode(head.val);
		ListNode curr = head.next;
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
		
		return newHead.next;
    }
	
	class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) {
	      val = x;
	      next = null;
	  }
	}

	/**
	 * 归并排序
	 * @param head
	 * @return
	 */
	public ListNode sortList2(ListNode head) {
		
		if (head == null) {
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		
		ListNode n = mergeSort(head, null);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
		
		return n.next;
	}
	
	public ListNode mergeSort(ListNode s, ListNode e) {
		
		if (s.next == e || s.next.next == null) {
			ListNode h = new ListNode(s.val);
			h.next = new ListNode(s.next.val);
			return h;
		}
		
		ListNode oneStep = s;
		ListNode twoStep = s;
		
		while (twoStep != e && twoStep.next != null) {
			
			oneStep = oneStep.next;
			twoStep = twoStep.next;
			if (twoStep.next != null) {
				twoStep = twoStep.next;
			}
		}
		
		ListNode l = mergeSort(s, oneStep);
		ListNode r = mergeSort(oneStep, e);
		return merge(l, r);
	}

	public ListNode merge(ListNode l, ListNode r) {

		ListNode head = new ListNode(0);
		ListNode mList = head;
		while (l.next != null && r.next != null) {

			if (r.next.val < l.next.val) {
				mList.next = new ListNode(r.next.val);
				r = r.next;
			} else {
				mList.next = new ListNode(l.next.val);
				l = l.next;
			}
			mList = mList.next;
		}

		while (l.next != null) {
			mList.next = new ListNode(l.next.val);
			l = l.next;
			mList = mList.next;
		}

		while (r.next != null) {
			mList.next = new ListNode(r.next.val);
			r = r.next;
			mList = mList.next;
		}

		return head;
	}
	
}
