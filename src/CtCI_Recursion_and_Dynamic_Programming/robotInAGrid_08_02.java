package CtCI_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashSet;

public class robotInAGrid_08_02 {

	static class Point {

		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}


	}

//	public static ArrayList<Point> getPath(boolean[][] maze) {
//
//	}

	public static void main(String[] args) {
		HashSet<Point> failedPoints = new HashSet<>();

		Point p1 = new Point(1, 2);
		failedPoints.add(p1);
		Point p2 = new Point(1, 2);
		if (failedPoints.contains(p2)) {
			System.out.println("Already present");
		}
	}
}
