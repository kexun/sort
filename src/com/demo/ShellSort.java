package com.demo;

/**
 * 希尔排序
 * 
 * 之前介绍的选择排序，直接插入排序，冒泡排序的时间复杂度都是O(n2)，
 * 但是这次介绍的希尔排序是一个重大突破，他的平均时间复杂度是O(nlogn),
 * 那么希尔排序的秘诀是什么呢？ 原来希尔排序是对直接插入排序的一个优化。
 * 
 * 直接插入排序：
 * 直接插入排序的做法是从头到尾依次逐个元素对比，这样做有什么问题呢，假如一个序列中，
 * 第一个元素恰好是整个序列中最大的一个元素，那么势必会在接下来的每次比较中都与这个
 * 元素对比，并将这个元素后移。这就是一个巨大的浪费。
 * 
 * 希尔排序：
 * 希尔排序是对直接插入排序的改进，具体的做法就是，他通过设定一个增量n，每次比较(x)和(x+n)
 * 两个元素。这样做的好处是什么呢？如果序列的第一个元素恰好是最大的元素，那么通过比较这个元素
 * 就直接被移动到了位置(1+n)，他可以大大减少不必要的比较，也就是队直接插入排序的一个缺陷上的
 * 改进。
 * @author kexun
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		
		int[] data = {
				100,11,20,3,4,5,6,7,8,9
		};
		
		ShellSort s = new ShellSort();
		s.sort(data);
		
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
		int increment = length;
		do {
			increment = increment/3+1;
			for (int i=increment; i<length; i++) {
				
//				index++;
				if (data[i] < data[i-increment]) {
					int temp = data[i];
					int j;
					for (j=i-increment; j>=0 && data[j]>temp; j-=increment) {
//						swap(data, j, j+increment);
						data[j+increment] = data[j];
						index++;
					}
					data[j+increment] = temp;
				}
			}
			
		} while (increment > 1);
		
		System.out.println("运行次数： "+index);

	}

	private void swap(int[] data, int j, int i) {

		int temp = data[j];
		data[j] = data[i];
		data[i] = temp;
	}
}








