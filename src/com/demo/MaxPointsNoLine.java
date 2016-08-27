package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given n points on a 2D plane, find the maximum number 
 * of points that lie on the same straight line.
 * 优化了部分代码，提高运行效率
 * @author kexun
 *
 */
public class MaxPointsNoLine {

	public static void main(String[] args) {

		
		Point p1 = 	new MaxPointsNoLine(). new Point(0,0);
		Point p2 = 	new MaxPointsNoLine(). new Point(1,0);
		Point p3 = 	new MaxPointsNoLine(). new Point(0,0);
		Point p4 = 	new MaxPointsNoLine(). new Point(0,0);
		Point p5 = 	new MaxPointsNoLine(). new Point(4,2);
		Point p6 = 	new MaxPointsNoLine(). new Point(8,4);
		Point[] pl = {p1, p2, p3, p4, p5,p6};
		
		MaxPointsNoLine m = new MaxPointsNoLine();
		int count = m.maxPoints(pl);
		System.out.println(count);
		
	}
	
	public int maxPoints(Point[] points) {

		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0;

		int length = points.length;
		if(length <= 2)
			return length;

		for (int i=0; i<length; i++) {
			
			Point p1 = points[i];
			int samePoint = 1;
			int yp = 1;
			for (int j=i+1; j<length; j++) {
				Point p2 = points[j];
				
				if (p1.x == p2.x && p1.y == p2.y) {
					samePoint++;
				} else if (p1.x == p2.x) {
					yp++;
				} else {
					double k = calLine(p1, p2);
					Integer temp = map.get(k);
					if (temp == null) {
						temp = 1;
					} else {
						temp++;
					}
					map.put(k, temp);
				}
			}
			
			for(Entry<Double, Integer> e : map.entrySet()) {
				int tempMax = e.getValue()+samePoint;
				if (tempMax > max)
					max = tempMax;
			}
			if (yp > max) {
				max = yp;
			}
			if (samePoint > max) {
				max = samePoint;
			}
			map.clear();
		}
		
		return max;
    }
	
	public boolean isSamePoint(Point p1, Point p2) {
		return p1.x == p2.x && p1.y == p2.y;
	}
	
	public double calLine(Point p1, Point p2) {

		double k = Double.MAX_VALUE;
		if (p2.x != p1.x) {
			k = (double) (1.0*(p2.y - p1.y)/(p2.x - p1.x));
		}
		
		if (Math.abs(k) == 0) {
			k = 0;
		}
		return k;
	}

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
		
	}
	
}
