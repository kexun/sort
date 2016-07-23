package com.demo;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，
 * 每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，
 * 但是为了省电，要是这个d最小，请找到这个最小的d。
 * 
 * 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。
 * 第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。
 * @author kexun
 *
 */
public class Light {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			
			int n = in.nextInt();
			int i = in.nextInt();
			int[] list = new int[n];
			for (int j=0; j<n; j++) {
				list[j] = in.nextInt();
			}
			
			sort(list);
			
			long maxDist = 0;
			for (int k=0; k<n-1; k++) {
				int temp = list[k+1] - list[k];
				if (temp > maxDist) {
					maxDist = temp;
				}
			}
			
			
			DecimalFormat df = new DecimalFormat("0.00");
			long result;
			long lastDist = (long) ((i-list[list.length-1])*1.0);
			long firstDist = (long) (list[0]*1.0);
			
			if (firstDist > lastDist) {
				result = firstDist;
			} else {
				result = lastDist;
			}
			if ((long) (maxDist/2.0) > result) {
				System.out.println(df.format(maxDist/2.0));
			} else {
				System.out.println(df.format(result));
			}
			
		}
	}
	
	public static void sort(int[] list) {
		
		int length = list.length;
		if (length <= 1) {
			return;
		}
		
		for (int i=0; i<length; i++) {
			for (int j=length-1; j>i; j--) {
				if (list[j] < list[j-1]) {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}
	}

}
