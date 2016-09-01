package com.demo;

import java.util.LinkedList;

/**
 * 给定一个数组，arr和一个大小为w的窗口，从窗口的左边滑倒最右边，每次滑动一个位置，
 * 如[4 3 5]4 3 3 6 7  最终返回的结果为5 5 5 4 6 7
 * @author kexun
 *
 */
public class MaxWindow {

	public static void main(String[] args) {

		int[] arr = {
				4,3,5,4,3,3,6,7
		};
		MaxWindow w = new MaxWindow();
		int[] result = w.getMaxWindow(arr, 3);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] getMaxWindow(int[] arr, int w) {
		
		int length = arr.length;
		int[] result = new int[length-w+1];
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int index = 0;
		for (int i=0; i<length; i++) {
			while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
				list.removeLast();
			}
			list.addLast(i);
			
			if (list.peekFirst() == i - w) {
				list.removeFirst();
			}
			
			if (i >= w -1 ) {
				result[index++] = arr[list.peekFirst()];
			}
		}
		
		return result;
	}
}
