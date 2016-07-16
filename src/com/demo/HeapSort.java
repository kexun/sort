package com.demo;

/**
 * 堆排序
 * @author kexun
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		
		int[] data = {
			50,10,90,30,70,40,80,60,20
		};
		
		HeapSort h = new HeapSort();
		h.sort(data);
		
		for (int d : data) {
			System.out.println(d);
		}
	}
	
	public void sort(int[] data) {
		
		int length = data.length;
		
		if (length <= 1) {
			return;
		}
		
		// 从length/2-1的元素开始遍历，因为length/2-1位置的元素是具有子节点的最后一个元素。
		// 从最后一颗树开始调整，选出最大节点。这里要注意的是，如果对树进行了调整，如果还有
		// 子树，那继续对其子树调整。
		for (int i=length/2-1; i>=0; i--) {
			heapAdjust(data, i, length);
		}
		
		// 这一步才是真正的排序，循环遍历所有元素，取最大的根节点，并与最后一个元素互换，然后从新
		// 调整大根堆，再获取根节点，与倒是第二个位置的元素互换。注意每次调整后，数组长度要减1。
		for (int j=length-1; j>=0; j--) {
			swap(data, 0, j);
			heapAdjust(data, 0, j);
		}
	}

	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// 调整堆，使其成为大根堆
	private void heapAdjust(int[] data, int root, int length) {
		
		int temp = data[root];
		
		for (int i = root*2+1; i<length; i=i*2+1) {
			if (i < length-1) {
				if (data[i] < data[i+1]) {
					i++;
				}
			}
			
			if (temp < data[i]) {
				data[root] = data[i];
				data[i] = data[root];
				root = i;
			}
		}
		
		data[root] = temp;
	}

}
