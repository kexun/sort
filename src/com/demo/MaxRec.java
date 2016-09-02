package com.demo;

import java.util.Stack;

/**
 * 求一个只有0和1的矩阵中，只包含1的最大矩阵的1的个数
 * @author kexun
 *
 */
public class MaxRec {

	public static void main(String[] args) {

		int[][] arr = {
				{1,1,1,1,0,0},
				{1,0,1,1,0,0},
				{1,0,1,1,0,0},
				{1,0,1,1,0,1},
				{1,1,0,1,1,1}
		};
		MaxRec m = new MaxRec();
		int max = m.maxRecSize(arr);
		System.out.println(max);
	}

	/**
	 * 首先读取每行的数据，统计出每行的高度，
	 * 定义如下：以当前行为底，向上找，如果上一行为1，则层高加1，如果为0，则当前行高为1。
	 * 如果当前行为0，则行高为0
	 * @param arr
	 * @return
	 */
	public int maxRecSize(int[][] arr) {
		
		int max = 0;
		int[] height = new int[arr[0].length];
		for (int i=0; i<arr.length; i++) {
			
			for (int j=0; j<arr[0].length; j++) {
				height[j] = arr[i][j] == 0 ? 0 : height[j]+1;
			}
			max = Math.max(max, maxRecFromBottom(height));
		}
		
		return max;
	}
	
	/**
	 * 给定每一层的行高，求出当前包含的最大的数。
	 * @param height
	 * @return
	 */
	public int maxRecFromBottom(int[] h) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int max = 0;
		int k;
		int j;
		for (int i=0; i<h.length; i++) {
			
			int curr = h[i];
			while (!stack.isEmpty() && curr <= h[stack.peek()]) {
				k = stack.pop();
				j = stack.isEmpty()? -1 : stack.peek();
				int value = (i-j-1) * h[k];
				max = Math.max(max, value);
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			k = stack.pop();
			j = stack.isEmpty()? -1 : stack.peek();
			int value = (h.length - j - 1) * h[k];
			max = Math.max(max, value);
		}
		return max;
	}

}







