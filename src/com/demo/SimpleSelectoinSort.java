package com.demo;

/**
 * 简单选择排序
 * 选择排序和冒泡的区别是，选择排序首先先经过一轮比较，选择出一个最小的，然后交换。
 * @author kexun
 *
 */
public class SimpleSelectoinSort {

	public static void main(String[] args) {

		int[] data = {
				2,1,3,4,5,6,7,8,9,10
		};
		
		SimpleSelectoinSort s = new SimpleSelectoinSort();
		s.sort(data);
		
		for (int a : data) {
			System.out.println(a);
		}
	}

	
	public void sort(int[] data) {

		int length = data.length;
		if (length <= 1) {
			return;
		}
		
		int min;
		for (int i=0; i<length; i++) {
			
			min = i;
			int temp = data[i];
			for (int j=i; j<length; j++) {
				
				if (data[j] < temp) {
					min = j;
					temp = data[j];
				}
			}
			
			if (min != i) {
				swap(data, min, i);
			}
		}
	}


	private void swap(int[] data, int min, int i) {

		int temp = data[min];
		data[min] = data[i];
		data[i] = temp;
	}
}
