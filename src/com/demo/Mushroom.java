package com.demo;

import java.util.Scanner;

/**
 * 在N*M的草地上,提莫种了K个蘑菇,蘑菇爆炸的威力极大,兰博不想贸然去闯,而且蘑菇是隐形的.
 * 只 有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇,于是他回了一趟战争学院,买了2个扫描透镜,
 * 一个 扫描透镜可以扫描出(3*3)方格中所有的蘑菇,然后兰博就可以清理掉一些隐形的蘑菇. 
 * 问:兰博最多可以清理多少个蘑菇?注意：每个方格被扫描一次只能清除掉一个蘑菇。
 * 
 * 注意： 这里要注意输入的k个数的起始位置是从1开始的，所以需要转换成0开始，不然会溢出，这个问题花了我好长时间，
 * 所以读题一定要清楚
 * @author kexun
 *
 */
public class Mushroom {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			if (n<3) n=3;
			if (m<3) m=3;
			
			int[][] array = new int[n][m];
			for (int i=0; i<k; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
					array[x-1][y-1]++;
			}
			
			int m1 = findMax(array);
			int m2 = findMax(array);
			System.out.println(m1+m2);
		}
		
	}
	
	public static int findMax(int[][] array) {
		
		int lx = array.length;
		int ly = array[0].length;
		int max = 0;
		int startx = 0;
		int starty = 0;
		
		for (int i=0; i<=lx-3; i++) {
			
			for (int j=0; j<=ly-3; j++) {
				
				int tempMax = 0;
				for (int m=i; m<i+3; m++) {
					for (int n=j; n<j+3; n++) {
						if (array[m][n] > 0) {
							tempMax++;
						}
					}
				}
				
				if (tempMax > max) {
					max = tempMax;
					startx = i;
					starty = j;
				}
			}
		}
		
		for (int i=startx; i<startx+3; i++) {
			for (int j=starty; j<starty+3; j++) {
				array[i][j]--;
			}
		}
		
		return max;
	}
	

}

