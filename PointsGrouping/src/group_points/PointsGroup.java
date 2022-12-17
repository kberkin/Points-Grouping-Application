package group_points;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point2D{
	Point2D() {}
	static double distance ;
	static String symbol = null;
	public static int x;
	public static int y;
	
	Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	
	public static List<Point2D> calDis() {
		Scanner inp = new Scanner(System.in);
		
		List<Point2D> points = new ArrayList<Point2D>();
		
		try {
			Scanner inFile = new Scanner(new File("points.txt"));
			
			System.out.println("Enter x : ");
			x = inp.nextInt();
			System.out.println("Enter y : ");
			y = inp.nextInt();
			
			Point2D p = new Point2D(x,y);
			points.add(p);
			
			System.out.println(points);
			
			int mindex = 0;
			double mind = 100.0;
			double distance;
			
			while(inFile.hasNextLine()){
				String line = inFile.nextLine();
				
				String[] check = line.split(",");
				
				distance = Math.sqrt(Math.pow((x - Integer.parseInt(check[0])),2) + Math.pow((y - Integer.parseInt(check[1])),2));
				
				if (distance < mind) {
					mind = distance;
					mindex = Integer.parseInt(check[2]);
				}
				
			}
			System.out.println("Minimum Distance : "+mind);
			
			switch(mindex) {
			case 0 :
				Point0 p0 = new Point0(x,y);
				System.out.println("Point added into this group : "+p0.toString());
				break;
			case 1 :
				Point1 p1 = new Point1(x,y);
				System.out.println("Point added into this group : "+p1.toString());
				break;
			case 2 :
				Point2 p2 = new Point2(x,y);
				System.out.println("Point added into this group : "+p2.toString());
				break;
			case 3 :
				Point3 p3 = new Point3(x,y);
				System.out.println("Point added into this group : "+p3.toString());
				break;
			default :
				break;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return points;
	}
	
	@Override
	public String toString() {
		return "Points : "+x+","+y;
	}
}
class Point0 extends Point2D{
	Point0() {}
	Point0(int x, int y){
		super(x, y);
		symbol = "0";
	}
	@Override
	public String toString() {
		return symbol;
	}
}
class Point1 extends Point2D{
	Point1() {}
	Point1(int x, int y){
		super(x,y);
		symbol = "1";
	}
	@Override
	public String toString() {
		return symbol;
	}
}
class Point2 extends Point2D{
	Point2() {}
	Point2(int x, int y){
		super(x,y);
		symbol = "2";
	}
	@Override
	public String toString() {
		return symbol;
	}
}
class Point3 extends Point2D{
	Point3() {}
	Point3(int x, int y){
		super(x,y);
		symbol = "3";
	}
	@Override
	public String toString() {
		return symbol;
	}
}

public class PointsGroup {
	
	public static void main(String[] args) {
		Point2D p2D = new Point2D();
		p2D.calDis();
	}
}