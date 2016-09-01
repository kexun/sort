package com.demo;

import java.util.Scanner;

/**
 * 蛇数， 输入一个数字w， 成立一个w*w的矩阵，依次从1开始环绕输入如
 * w = 3
 * 
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * 最后输出  从上到下 输出每一行的数字 1 2 3 8 9 4 7 6 5
 * @author kexun
 *
 */
public class SnakeNumber {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			
			int w = in.nextInt();
			int[][] a = SnakeNumber.sort(w);
			for (int i=0; i<a.length; i++) {
				for (int j=0; j<a[0].length; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
		}
	}

	
	public static int[][] sort(int w) {
		
		int[][] array = new int[w][w];
		int a = 0;
		int b = 0;
		int index = 1;
		
		while (index <= (w*w)) {
			
			for (int j=0; j<w; j++) {
				if (array[a][j] == 0) {
					array[a][j] = index++;
					b = j;
				}
			}
			
			for (int i=0; i<w; i++) {
				if (array[i][b] == 0) {
					array[i][b] = index++;
					a = i;
				}
			}
			
			for (int j=b; j>=0; j--) {
				if (array[a][j] == 0) {
					array[a][j] = index++;
					b = j;
				}
			}
			
			for (int i=a; i>=0; i--) {
				if (array[i][b] == 0) {
					array[i][b] = index++;
					a = i;
				}
			}
		}
		
		
		return array;
	}
}
