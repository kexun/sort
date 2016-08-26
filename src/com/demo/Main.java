package com.demo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int h = n;
			int l = m;
			int[][] array = new int[n][m];
			
			for (int i=0; i<n; i++) {
				
				int row = in.nextInt();
				for (int j=0; j<m; j++) {
					array[i][j] = row % 10;
					row = row / 10;
				}
			}
			
			
		}
	}

	public static int findMax(int[][] array) {
		
		int n = array.length;
		int m = array[0].length;
		
		if (n < 4 && m < 4) {
			int min = 10;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (array[i][j] < min) {
						min = array[i][j];
					}
				}
			}
			return min;
		} else {
			int max = 0;
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (array[i][j] > max) {
						max = array[i][j];
					}
				}
			}
			return max;
		}
		
		
	}
	
}








