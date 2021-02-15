package dz.fractal;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import dz.fractal.recursive.Cantor;
import dz.fractal.recursive.Example;
import dz.fractal.recursive.Koch;
import dz.fractal.recursive.KochSnowflake;

@SuppressWarnings("serial")
public class DrawFrame extends Frame {
	private final static Color[] RAIN_BOW = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75,0,130), new Color(102,0,153)};
	
	public void paint(Graphics g) {
		drawKoch(g, getWidth(), getHeight());
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
		
		ex.paint((i, line)->{
			int k = i%7;
			g.setColor(RAIN_BOW[k]);
			
			drawDot(g, line.getX1(), line.getY1(), w, h, width, height);
		});	
	}
	
	protected void drawCantor(Graphics g, int width, int height) {
		Cantor cantor = new Cantor(10, 10, width-10, 10, 50);
		
		cantor.paint(line->drawLine(g, line.getX1(), line.getY1(), line.getX2(), line.getY2(), width, height));
	}
	
	protected void drawKochSnowflake(Graphics g, int width, int height) {
		g.setColor(Color.YELLOW);
		int i=10;
		KochSnowflake snowflake = new KochSnowflake(280, 10, 164.5, 210.0, i);
		
		snowflake.paint(line->drawLine(g, line.getX1(), line.getY1(), line.getX2(), line.getY2(), width, height));		
		
		snowflake = new KochSnowflake(164.5, 210, 395.5, 210.0, i);
		
		snowflake.paint(line->drawLine(g, line.getX1(), line.getY1(), line.getX2(), line.getY2(), width, height));
		
		snowflake = new KochSnowflake(395.5, 210, 280, 10, i);
		
		snowflake.paint(line->drawLine(g, line.getX1(), line.getY1(), line.getX2(), line.getY2(), width, height));				
	}
	
	protected void drawKoch(Graphics g, int width, int height) {
		g.setColor(Color.YELLOW);
		int i=2;
		
		Koch koch = new Koch(100, 0, 1780, 0, i);
		koch.paint(line->drawLine(g, line.getX1(), line.getY1(), line.getX2(), line.getY2(), width, height));
	}
}
