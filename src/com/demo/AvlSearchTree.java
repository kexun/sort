package com.demo;

/**
 * 通过有序数组生成平衡搜索二叉树
 * @author kexun
 *
 */
public class AvlSearchTree {

	public static void main(String[] args) {

		int[] array = {
				10,20,40,50,70,80,100
		};
		AvlSearchTree a = new AvlSearchTree();
		Tree head = a.generate(array, 0, array.length-1);
		System.out.println(head.data);
	}

	public Tree generate(int[] array, int start, int end) {
		
		if (start == end) {
			return new Tree(array[start]);
		}
		
		if (end - start == 1) {
			Tree temp = new Tree(array[start]);
			temp.right = new Tree(array[end]);
			return temp;
		}
		
		int mid = (end + start) / 2;
		Tree head = new Tree(array[mid]);
		head.left = generate(array, start, mid-1);
		head.right = generate(array, mid+1, end);
		return head;
	}
	
}
