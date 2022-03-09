package aa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Vernoi {
	BufferedImage img;
	Vector<Point> pts = new Vector<Point>();
	
	public Vernoi(int res,int n) {
		Random rand = new Random();
		//init image
		img = new BufferedImage( res , res , BufferedImage.TYPE_INT_RGB);
		
		//add points
		for(int i = 0;i < n;i++) {
			pts.add( new Point( rand.nextDouble() * res, rand.nextDouble() * res));
		}
			
	}
	
	public void render() {
		for(int x = 0; x < img.getWidth();x++) {
			for(int y = 0; y < img.getHeight();y++) {
				Point c = new Point(x,y);
				double md=10e10; //minimum distance
				int color=0;
				
				//find nearest point
				for(Point p : pts) {
					if ( c.d(p) < md) {
						md = c.d(p);
						color = p.color;
					}
				}
				
				img.setRGB(x, y, color);
			}
		}
	}
	
	public boolean save(String filename) {
		File f = new File(filename);
		try {
			ImageIO.write(img,"png",f);
			return true;
		}catch( Exception e) {
			return false;
		}
	}
	
	public int rgb(int r,int g,int b) {
		return r << 16 | g << 8 | b;
	}
}
