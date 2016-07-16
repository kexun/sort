package com.demo;

/**
 * 归并排序
 * @author kexun
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] data = {
				5,2,45,32,76,357,46,3,4,57,56,6578,56,33,5,52,7,89,64,3,524,11,3
			};
		
		int[] dest = new int[data.length];
		
		MergeSort m = new MergeSort();
		m.sort(data, dest);
		for (int d : dest) {
			System.out.println(d);
		}

	}

	
	public void sort(int[] data, int[] dest) {
		
		int length = data.length;
		if (length <= 1) {
			return;
		}
		
//		mergeSort(data, dest, 0, length-1);
		
		mergeSort2(data, dest, length);
	}

	// 第一种方法：递归调用
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

	///////////////////////////////////////////////////////////////////////////
	
	// 第二种方式，非递归方式排序, 特别要注意这里的一些边界情况
	// 这里用到了两个数组 data和dest，这两个数组在merge的时候相互调换使用，
	// 第一次是data->dest  第二次dest->data 但是最后一次必须确保是data->dest
	// 因此就出现了
	//			  if (k > length) {
	//   				System.arraycopy(data, 0, dest, 0, length);
	// 			  }
	// 这个数组拷贝是为了防止，最后一次数据合并没有发生在dest上 而是data上， 所以讲data的数据拷贝
	// 到dest上去。
	private void mergeSort2(int[] data, int[] dest, int length) {
		
		int k = 1;
		while (k <= length) {
			mergePass(data, dest, k, length);
			k*=2;
			mergePass(dest, data, k, length);
			k*=2;
			if (k > length) {
				System.arraycopy(data, 0, dest, 0, length);
			}
		}
		
	}
	
	// 循环遍历数组，k是2^n，就是每个子序列的长度。两两合并所有字序列，如果
	// 最后还剩下一组序列就把这一组序列填充到目标数组上，如果最后剩下两组序列,
	// 但是最后一组序列长度不足k，任然可以合并两个数组。
	private void mergePass(int[] data, int[] dest, int k, int length) {
		
		int i = 0;
		while (i <= length-2*k) {
			merge(data, dest, i, i+k-1, i+2*k-1);
			i = i + 2*k;
		}
		
		if ((length-i) > k) {
			merge(data, dest, i, i+k-1, length-1);
		} else {
			for (int j = i; j < length; j++) {
				dest[j] = data[j];
			}
		}
		
	}
	
	// 合并两个排序的数组，这个是公共方法，两种归并方式都会用到
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















