package com.demo;

/**
 * 二叉树的序列号 和 反序列化
 * @author kexun
 *
 */
public class TreeSeri {

	public static void main(String[] args) {

		Tree head = new Tree(1);
		Tree h2 = new Tree(2);
		Tree h3 = new Tree(3);
		Tree h4 = new Tree(4);
		Tree h5 = new Tree(5);
		Tree h6 = new Tree(6);
		Tree h7 = new Tree(7);
		Tree h8 = new Tree(8);
		Tree h9 = new Tree(9);
		Tree h10 = new Tree(10);
		
		head.left = h2;
		head.right = h3;
		h2.left = h4;
		h2.right = h5;
		h4.left = h6;
		h5.right = h7;
		h3.left = h8;
		h3.right = h9;
		h9.right = h10;

		TreeSeri t = new TreeSeri();
		// 序列化
		String res = t.serialize(head);
		System.out.println(res);
		// 反序列化
		Tree tree = t.deserialize(res);
		res = t.serialize(tree);
		System.out.println(res);
	}
	
	/**
	 * 序列化，将二叉树以先序的方式转成字符串。每个元素结束都以！结尾，如果是空表示#!
	 * @param head
	 * @return
	 */
	public String serialize(Tree head) {
		
		String res = "";
		if (head == null) {
			return "#!";
		}
		
		res = head.data+"!";
		String sl = serialize(head.left);
		res += sl;
		String sr = serialize(head.right);
		res += sr;
		
		return res;
	}
	
	/**
	 * 反序列化， 将字符串还原成二叉树。
	 * @param str
	 * @return
	 */
	public Tree deserialize(String str) {
		
		String[] array = str.split("!");
		
		if (array.length == 0) {
			return null;
		}
		
		Tree head = revert(array);
		return head;
	}
	
	//这个遍历i是为了控制数组的遍历，在递归的时候，依然能逐个依次获取到数组中的每个元素。
	public int i = 0;
	public Tree revert(String[] array) {
		
		String data = array[i];
		if ("#".equals(data) || i >= array.length) {
			return null;
		} else {
			i++;
			Tree left = revert(array);
			i++;
			Tree right = revert(array);
			Tree tree = new Tree(Integer.valueOf(data));
			tree.left = left;
			tree.right = right;
			return tree;
		}
		
	}

}
