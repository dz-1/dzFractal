package dz.fractal;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import dz.fractal.recursive.Cantor;
import dz.fractal.recursive.Example;

@SuppressWarnings("serial")
public class DrawFrame extends Frame {
	private final static Color[] RAIN_BOW = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75,0,130), new Color(102,0,153)};
	
	public void paint(Graphics g) {
		//drawExample(g, getWidth(), getHeight());
		
		drawCantor(g, getWidth(), getHeight());
	}
	
	protected void drawDot(Graphics g, double x, double y, int w, int h, int width, int height) {
		if (x+w<width && y+h<height) {
			g.drawLine((int) (x) + w, (int) (y) + h, (int) (x) + w, (int) (y) + h);				
		}
	}
	
	protected void drawLine(Graphics g, double x1, double y1, double x2, double y2, int width, int height) {
		if (x1 < width && x2 < width
				&& y1 < height && y2 < height) {
			g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
		}
	}
	
	protected void drawExample(Graphics g, int width, int height) {
		int w = width/2;
		int h = height/2;

		Example ex = new Example(1, 4, 60, 1000000);
		
		ex.paint(dot->{
			int k = dot.getIndex()%7;
			g.setColor(RAIN_BOW[k]);
			
			drawDot(g, dot.getX(), dot.getY(), w, h, width, height);
		});	
	}
	
	protected void drawCantor(Graphics g, int width, int height) {
		Cantor cantor = new Cantor(10, 10, width-10, 10, 50);
		
		cantor.paint(line->{
			drawLine(g, line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY(), width, height);
		});
	}
}
