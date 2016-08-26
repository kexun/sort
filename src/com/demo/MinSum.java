package com.demo;

import java.util.HashMap;
import java.util.Scanner;

public class MinSum {
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			String key = in.nextLine();
			String[] list = key.split(" ");
			for (String s : list) {
				map.put(s, 1);
			}
			System.out.println(map.size());
		}
	}
}
