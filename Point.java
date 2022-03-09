package aa;

import java.util.Random;

public class Point {
	public int x,y;
	public int color;
	static Random rand = new Random(0);
	
	public Point() {
		this(0,0);
	}
	
	public Point(double x,double y) {
		this( (int)(Math.round(x)) , (int)(Math.round(y)));
	}
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
		color = rainbow(rand.nextDouble());
		
	}
	
	//distance
	public double d(Point p) {
		return Math.sqrt( Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) );
	}
	
	//manchester distance
	public double md(Point p) {
		return Math.abs(x - p.x) + Math.abs(y - p.y);
	}
	
	public int rainbow(double s) {
		double 	r = Math.sin(s * 2 * Math.PI),
				g = Math.sin((s + 0.333) * 2 * Math.PI),
				b = Math.sin((s + 0.666) * 2 * Math.PI);
		
		return (int)((r + 1) / 2 * 255) << 16 | (int)((g + 1) / 2 * 255) << 8 | (int)((b + 1) / 2 * 255);
	}
}
