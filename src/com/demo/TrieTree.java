package com.demo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Trie树
 * 
 * 输入的第一行为一个正整数n，表示词典的大小，其后n行，每一行一个单词
 * （不保证是英文单词，也有可能是火星文单词哦），单词由不超过10个的小写英文字母组成，
 * 可能存在相同的单词，此时应将其视作不同的单词。接下来的一行为一个正整数m，表示小Hi询问的次数，
 * 其后m行，每一行一个字符串，该字符串由不超过10个的小写英文字母组成，表示小Hi的一个询问。
 * 在20%的数据中n, m<=10，词典的字母表大小<=2.
 * 在60%的数据中n, m<=1000，词典的字母表大小<=5.
 * 在100%的数据中n, m<=100000，词典的字母表大小<=26.
 * @author kexun
 *
 */
public class TrieTree {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int a = in.nextInt();
			HashMap<String, Object> map = new HashMap<String, Object>();
			while (a-- > 0) {
				
				HashMap<String, Object> tempMap = map;
				String str = in.next();
				for (int i=0; i<str.length(); i++) {
					char ch = str.charAt(i);
					
					HashMap<String, Object> newMap = (HashMap<String, Object>) tempMap.get(String.valueOf(ch));
					if (newMap == null) {
						newMap = new HashMap<String, Object>();
						newMap.put("count", 1);
						tempMap.put(String.valueOf(ch), newMap);
					} else {
						int count = (int) newMap.get("count");
						newMap.put("count", ++count);
					}
					
					tempMap = newMap;
				}
				
			}
			
			int b = in.nextInt();
			while (b-- > 0) {

				HashMap<String, Object> tempMap = map;
				String str = in.next();
				
				for (int i=0; i<str.length(); i++) {
					char ch = str.charAt(i);
					HashMap<String, Object> newMap = (HashMap<String, Object>) tempMap.get(String.valueOf(ch));
					if (newMap != null) {
						tempMap = newMap;
					} else {
						tempMap = newMap;
						break;
					}
				}
				
				if (tempMap != null) {
					Integer count = (Integer) tempMap.get("count");
					System.out.println(count);
				} else {
					System.out.println(0);
				}
				
			}
			
		}
		
		
	}

}
