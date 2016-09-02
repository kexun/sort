package com.demo;

import java.util.LinkedList;

/**
 * 最大值减最小值<=num的子数组数量
 * @author kexun
 *
 */
public class MaxMinArrNum {

	public static void main(String[] args) {

		int[] array = {
				1,2,3,4,5,6
		};
		MaxMinArrNum m = new MaxMinArrNum();
		int re = m.getNum(array, 2);
		System.out.println(re);
	}

	public int getNum(int[] array, int num) {
		
		int length = array.length;
		if (num < 0) {
			return 0;
		}
		
		int result = 0;
		int i = 0;
		int j = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		
		while (i < length) {
			
			while (j < length) {
				
				while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[j]) {
					qmax.removeLast();
				}
				qmax.addFirst(j);
				
				while (!qmin.isEmpty() && array[qmin.peekLast()] >= array[j]) {
					qmin.removeLast();
				}
				qmin.addLast(j);
				
				if ((array[qmax.peekFirst()] - array[qmin.peekFirst()]) > num) {
					break;
				}
				j++;
			}
			
			if (qmax.peekFirst() == i) {
				qmax.removeFirst();
			}
			
			if (qmin.peekFirst() == i) {
				qmin.removeFirst();
			}
			
			result += j - i;
			i++;
		}
		
		return result;
	}
	
}
