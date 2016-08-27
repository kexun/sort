package com.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number 
 * of points that lie on the same straight line.
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

		Map<Line, Set<MyPoint>> map = new HashMap<Line, Set<MyPoint>>();
		int max = 0;
		MyPoint[] myPoints = new MyPoint[points.length];
		
		for (int i=0; i<points.length; i++) {
			
			Point p1 = points[i];
			if (p1 == null) {
				continue;
			}
			MyPoint mp1 = myPoints[i];
			if (mp1 == null) {
				mp1 = new MyPoint(p1);
				myPoints[i] = mp1;
			}
			
			Set<MyPoint> set = new HashSet<MyPoint>();
			for (int j=i+1; j<points.length; j++) {

				Point p2 = points[j];
				if (p2 == null) {
					continue;
				}
				
				MyPoint mp2 = myPoints[j];
				if (mp2 == null) {
					mp2 = new MyPoint(p2);	
					myPoints[j] = mp2;
				}
				
				if (!isSamePoint(p1, p2)) {
					Line line = calLine(p1, p2);
					set = map.get(line);
					if (set == null) {
						set = new HashSet<MyPoint>();
						map.put(line, set);
					}
					set.add(mp1);
					set.add(mp2);
				} else {
					mp1.add();
					points[j] = null;
					myPoints[j] = null;
				}
			}
		}
		
		Iterator<Entry<Line, Set<MyPoint>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Set<MyPoint> list = it.next().getValue();
			int count = 0;
			for (MyPoint p : list) {
				count += p.count;
			}
			if (count > max) {
				max = count;
			}
		}
		
		if (max == 0) {
			return points.length;
		}
		return max;
    }
	
	public boolean isSamePoint(Point p1, Point p2) {
		return p1.x == p2.x && p1.y == p2.y;
	}
	
	public Line calLine(Point p1, Point p2) {

		double k = Double.MAX_VALUE;
		double b = 0;
		if (p2.x != p1.x) {
			k = (double) (1.0*(p2.y - p1.y)/(p2.x - p1.x));
		}
		
		if (k == 0) {
			b = p2.y;
		} else if (k == Double.MAX_VALUE) {
			b = p2.x;
		} else {
			b = p2.y - k*p2.x;
		}
		return new Line(k, b);
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
	
	class MyPoint {
		
		Point p;
		int count = 1;
		
		public MyPoint(Point p) {
			this.p = p;
		}
		
		public void add() {
			count++;
		}
		
		public boolean equals(Point obj) {
			if (obj == null)
				return false;
			return p.x == obj.x && p.y == obj.y;
		}
	}
	
	public class Line {
		public double k;
		public double b;
		
		Line(double k, double b) {
			this.k =  new BigDecimal(k).setScale(4, BigDecimal.ROUND_DOWN).doubleValue();
			this.b = new BigDecimal(b).setScale(4, BigDecimal.ROUND_DOWN).doubleValue();
		}

		@Override
		public boolean equals(Object obj) {
			boolean a = this.k == ((Line)obj).k && this.b == ((Line)obj).b;
			return a;
		}
		
		@Override
		public int hashCode() {
			return 1;
		}
	}
	 
}
