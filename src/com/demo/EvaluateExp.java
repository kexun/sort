package com.demo;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author kexun
 *
 */
public class EvaluateExp {

	public static void main(String[] args) {
		String[] array = {
				"2","1","+","3","*"
		};
		EvaluateExp e = new EvaluateExp();
		int result = e.evalRPN(array);
		System.out.println(result);
	}

	public int evalRPN(String[] tokens) {
    
		Stack stack = new Stack();
		
		for (String t : tokens) {
			
			if (t.equals("+")) {
				int temp = stack.pop().data + stack.pop().data;
				Node node = new Node(temp);
				stack.offer(node);
			} else if (t.equals("-")) {
				int temp1 = stack.pop().data;
				int temp2 = stack.pop().data;
				Node node = new Node(temp2 - temp1);
				stack.offer(node);
			} else if (t.equals("*")) {
				int temp = stack.pop().data * stack.pop().data;
				Node node = new Node(temp);
				stack.offer(node);
			} else if (t.equals("/")) {
				int temp1 = stack.pop().data;
				int temp2 = stack.pop().data;
				Node node = new Node(temp2 / temp1);
				stack.offer(node);
			} else {
				Node node = new Node(Integer.valueOf(t));
				stack.offer(node);
			}
			
		}
		return stack.pop().data;
    }
    
	class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	class Stack {
		
		public Node head = new Node(0);
		
		public void offer(Node node) {
			node.next = head.next;
			head.next = node;
		}
		
		public Node pop() {
			Node node = head.next;
			head.next = node.next;
			return node;
		}
		
	}
}
