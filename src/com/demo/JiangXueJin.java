package com.demo;

import java.util.Scanner;

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，
 * 小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 * 
 * 输入描述:
第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1


输出描述:
一行输出答案。

输入例子:
5 10 9
0 5
9 1
8 1
0 1
9 100

输出例子:
43
 * @author kexun
 *
 */
public class JiangXueJin {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			
			int count = in.nextInt();
			int r = in.nextInt();
			int avg = in.nextInt();
			
			int total = avg*count;
			int myScore = 0;

			Score[] list = new Score[count];
			for (int i=0; i<count; i++) {
				int ai = in.nextInt();
				int bi = in.nextInt();
				list[i] = new Score(ai, bi, r);
				myScore+=ai;
			}
			
			sort(list);
			int remain = total - myScore;
			if (remain <= 0) {
				System.out.println(0);
			} else {
				int value = 0;
				// 要考虑大树问题，所以要用long
				long time = 0;
				
				int k = 0;
				for (k=0; k<count; k++) {
					value += list[k].lastAi;
					time += list[k].lastAi*list[k].bi;
					if (value > remain) {
						value -= list[k].lastAi;
						time -= list[k].lastAi*list[k].bi;
						break;
					}
				}
				
				System.out.println(time+(remain-value)*list[k].bi);
			}
			
			
		}
		
	}
	

	public static void sort(Score[] list) {
		
		int length = list.length;
		if (length <= 1) {
			return;
		}
		
		for (int i=0; i<length; i++) {
			
			for (int j=length-1; j>i; j--) {
				if (list[j].bi < list[j-1].bi) {
					Score temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}
		
	}
	
	static class Score {
		public int ai;
		public int bi;
		public int lastAi;
		
		public Score(int ai, int bi, int r) {
			this.ai = ai;
			this.lastAi = r-ai;
			this.bi = bi;
		}
		
	}

}
