package com.demo;

/**
 * 直接插入排序
 * 插入排序算法的核心就是将一个数据插入已经排序后的数列中，最好的情况下，当所有数据
 * 都是已排序好的，只需要比较O(n)次。最坏情况，如果数列是一个逆序列，则是O(n2)的开销
 * 
 * 下面实现的方法中，没有额外的空间开销，所有插入都是在一个数组中完成。是以时间换取了空间。
 * 因为每当将较小的数插入前面，就需要将前半部分元素向后移动一位。
 * 
 * 当然也可以用空间换取时间的方式，可以另外开辟一个等大小的数组，将排序后的元素插入新的数组中。
 * @author kexun
 *
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] data = {
				2,1
		};
		
		InsertSort i = new InsertSort();
		i.sort(data);
		
		for (int d : data) {
			System.out.println(d);
		}
	}
	
	public void sort(int[] data) {
		
		int length = data.length;
		
		if (length <= 1) {
			return;
		}
		
		int index = 0;
		for (int i=1; i<length; i++) {
			
			index++;
			if (data[i] < data[i-1]) {
				int temp = data[i];
				
				// 将数据插入，后面的元素向后移
				int j;
				for (j=i-1; j>=0 && data[j]>temp; j--) {
					index++;
					data[j+1] = data[j];
				}
				
				data[j+1] = temp;
			}
		}

		System.out.println("运行次数： "+index);
	}

}
