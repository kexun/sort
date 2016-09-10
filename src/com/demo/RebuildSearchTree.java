package com.demo;

/**
 * 根据后续数组重建搜索二叉树
 * @author kexun
 *
 */
public class RebuildSearchTree {

	public static void main(String[] args) {

		int[] array = {
			20,43,47,45,53,59,55,50,40,80,120,110,100,70	
		};
		
		RebuildSearchTree r = new RebuildSearchTree();
		boolean b = r.isSearchTree(array, 0, array.length - 1);
		System.out.println(b);
		
		Tree head = r.rebuildTree(array, 0, array.length - 1);
		r.afterOrder(head);
	}

	/**
	 * 给定一个二叉树的后续遍历结果数组，判断是否符合搜索二叉树。
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean isSearchTree(int[] array, int start, int end) {
		
		if (start == end) {
			return true;
		}
		
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (array[end] > array[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		
		if (less == -1 || more == end) {
			return isSearchTree(array, start, end-1);
		}
		
		if (less != more-1) {
			return false;
		}
		
		return isSearchTree(array, start, less) && isSearchTree(array, more, end-1);
	}
	
	/**
	 * 根据搜索二叉树的后续遍历结果，重构该二叉树。
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public Tree rebuildTree(int[] array, int start, int end) {
		
		if (start == end) {
			return new Tree(array[start]);
		}
		
		Tree pNode = new Tree(array[end]);
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (array[end] > array[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		
		if (less == -1) {
			pNode.right = rebuildTree(array, start, end-1);
		} else if (more == end) {
			pNode.left = rebuildTree(array, start, end-1);
		} else {
			pNode.left = rebuildTree(array, start, less);
			pNode.right = rebuildTree(array, more, end-1);
		}
		
		return pNode;
	}
	
	/**
	 * 后续遍历二叉树
	 * @param head
	 */
	public void afterOrder(Tree head) {
		
		if (head == null) {
			return;
		}
		
		afterOrder(head.left);
		afterOrder(head.right);
		System.out.println(head.data);
	}
}

