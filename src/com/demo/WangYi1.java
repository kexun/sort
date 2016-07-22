package com.demo;

import java.util.Scanner;

/**
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.
 * 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn. 
 * 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;
 * 如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,
 * 小易的最终能力值为多少?
 * @author kexun
 *
 */
public class WangYi1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			
			int count = in.nextInt();
			int a = in.nextInt();
			
			int[] list = new int[count];
			for (int i=0; i<count; i++) {
				list[i] = in.nextInt();
			}
			
			fight(a, list);
		}
	}

	private static void fight(int a, int[] b) {
		
		for (int i : b) {
			if (a >= i) {
				a+=i;
			} else {
				a+=maxDivisor(a, i);
			}
		}
		System.out.println(a);
	}

	/**
	 * 利用辗转相除法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int maxDivisor(int a , int b) {
		
		
		int big, small;
		if (a > b) {
			big = a;
			small = b;
		} else if (a < b) {
			big = b;
			small = a;
		} else {
			return a;
		}
		
		int y = big % small;
		while (y != 0) {
			big = small;
			small = y;
			y = big % small;
		}
		
		return small;
	}
}
