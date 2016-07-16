package com.demo;

/**
 * 归并排序
 * @author kexun
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] data = {
				50,10,90,30,70,40,80,60,20
			};
		
		int[] dest = new int[9];
		
		MergeSort m = new MergeSort();
		m.sort(data, data);
		for (int d : data) {
			System.out.println(d);
		}

	}

	
	public void sort(int[] data, int[] dest) {
		
		int length = data.length;
		if (length <= 1) {
			return;
		}
		
		mergeSort(data, dest, 0, length-1);
		
	}


	private void mergeSort(int[] data, int[] dest, int s, int e) {
		
		if (s == e) {
			dest[s] = data[s];
			return;
		}
		
		int[] to = new int[data.length];
		int m = (s+e)/2;
		mergeSort(data, to, s, m);
		mergeSort(data, to, m+1, e);
		merge(to, dest, s, m, e);
		
	}


	private void merge(int[] data, int[] dest, int s, int m, int e) {

		int j = m+1;
		int k = s;
		while (s <= m && j <= e) {
			
			if (data[s] > data[j]) {
				dest[k++] = data[j++];
			} else {
				dest[k++] = data[s++];
			}
		}
		
		while (s <= m) {
			dest[k++] = data[s++];
		}
		
		while (j <= e) {
			dest[k++] = data[j++];
		}
	}
	
}
