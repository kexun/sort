package com.demo;

import java.util.Scanner;

public class LISA {

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
		System.out.println(max);
	
	}

}
