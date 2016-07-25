package com.demo;

/**
 * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）
 * 例如：给定一个长度为8的数组A{1,3,5,2,4,6,7,8}，则其最长的单调递增子序列为{1,2,4,6,7,8}，长度为6.
 * 
 * 没有通过全部测试用例，可能问题是。如果存在多个最长子序列，应该打印第一个把。
 */
import java.util.Scanner;

public class LISA2 {

	public static void main(String[] args) {


		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int count = in.nextInt();
			
			for (int i=0; i<count; i++) {
				int length = in.nextInt();
				int[] array = new int[length];
				int[] values = new int[length];
				for (int j=0; j<length; j++) {
					array[j] = in.nextInt();
				}
				
				findMaxSLength(array, values);
			}
		}
	
	}
	
	public static void findMaxSLength(int[] array, int[] values) {
		
		int length = array.length;

		for (int i=0; i<length; i++) {
			if (i==0) {
				values[i] = 1;
			} else {
				
				int max = 0;
				for (int j=i-1; j>=0; j--) {
					if (array[j] < array[i]) {
						int temp = values[j] + 1;
						if (temp > max) {
							max = temp;
						}
					}
					values[i] = max == 0?1:max;
				}
				
			}
		}
		
		int max=0;
		for (int k : values) {
			if (k>max) {
				max = k;
			}
		}
		
		int[] out = new int[max];
		for (int k=values.length-1; k>=0; k--) {
			
			if (values[k] == max) {
				out[--max] = array[k];
				if (max == 0) {
					break;
				}
			}
		}
		
		for (int o : out) {
			System.out.print(o+" ");
		}
	
	}

}
