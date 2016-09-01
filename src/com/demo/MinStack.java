package com.demo;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public static void main(String[] args) {

		MinStack m = new MinStack();
		m.push(4);
		m.push(8);
		m.push(1);
		
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
	}
	
	public void push(Integer newVal) {
		
		if (minStack.isEmpty()) {
			minStack.push(newVal);
		} else {
			if (newVal < minStack.peek()) {
				minStack.push(newVal);
			}
		}
		stack.push(newVal);
	}
	
	public Integer pop() {
		
		if (stack.isEmpty()) {
			return null;
		}
		Integer result = stack.pop();
		if (!minStack.isEmpty()) {
			if (result.equals(minStack.peek())) {
				minStack.pop();
			}
		}
		return result;
	}
	
	public Integer getMin() {
		return minStack.peek();
	}
	
}
