package com.demo;

import java.util.Stack;

/**
 * 对栈进行排序，但是只能利用一个辅助栈，已经一个辅助变量。
 * @author kexun
 *
 */
public class SortStackByStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(10);
		stack.push(3);
		stack.push(1);
		stack.push(14);
		stack.push(0);
		stack.push(4);
		stack.push(4);
		
		SortStackByStack s = new SortStackByStack();
		s.sort(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public void sort(Stack<Integer> stack) {
		
		Stack<Integer> help = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer temp = stack.pop();
			if (help.isEmpty()) {
				help.push(temp);
			} else {
				if (temp > help.peek()) {
					while (!help.isEmpty()) {
						Integer helpItem = help.peek();
						if (temp > helpItem) {
							help.pop();
							stack.push(helpItem);
						} else {
							break;
						}
					}
				}
				help.push(temp);
			}
		}
		
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
