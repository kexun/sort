package com.demo;

/**
 * 快速排序，最经典的排序算法，首先找到基准数，然后从数组两边开始依次对比基准数，
 * 比基准数小的移动到前面，比基准数大的移动到后面，最终形成一个以基准数未分界点，
 * 左边的都比基准数小，右边的都比基准数大。然后递归调用左右两边的数组。
 * @author kexun
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		
		int[] data = new int[10000000];
		for (int i = 0; i < 10000000; i++) {
			int num =(int) (Math.random() * 100000000);
			data[i] = num;
		}
		
		long startTime = System.currentTimeMillis();
		QuickSort q = new QuickSort();
		q.sort(data);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
//		for (int d : data) {
//			System.out.println(d);
//		}
	}

	public void sort(int[] data) {
		
		int length = data.length;
		if (length <= 1) {
			return;
		}
		
		quickSort(data, 0, length-1);
	}
	
	private void quickSort(int[] data, int start, int end) {
		
		if (start >= end) {
			return;
		}
		
		int temp = data[start];
		int ts = start;
		int te = end;
		
		while (start < end) {
			
			while (data[end] >= temp && end > start) {
				end--;
			}
			
			if (end > start) {
				data[start] = data[end];
				start++;
			}
			
			while (data[start] < temp && end > start) {
				start++;
			}
			
			if (end > start) {
				data[end] = data[start];
				end--;
			}
			
		}
		
		data[start] = temp;
		
		quickSort(data, ts, start-1);
		quickSort(data, start+1, te);
	}
	
}
