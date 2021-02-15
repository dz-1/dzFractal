package dz.fractal;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.function.Consumer;

import dz.fractal.recursive.Cantor;
import dz.fractal.recursive.Example;
import dz.fractal.recursive.Koch;
import dz.fractal.recursive.KochSnowflake;

@SuppressWarnings("serial")
public class DrawFrame extends Frame {
	private final static Color[] RAIN_BOW = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75,0,130), new Color(102,0,153)};
	private final Consumer<Line2D> LINE_PAINTER = line->drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	private int width;
	private int height;
	private Graphics g;
	
	public void paint(Graphics g) {
		this.g = g;
		this.width = getWidth();
		this.height = getHeight();
		drawKoch(g);
	}
	
	protected void drawDot(double x, double y, int w, int h) {
		if (x+w<width && y+h<height) {
			g.drawLine((int) (x) + w, (int) (y) + h, (int) (x) + w, (int) (y) + h);				
		}
	}
	
	protected void drawLine(double x1, double y1, double x2, double y2) {
		if (x1 < width && x2 < width
				&& y1 < height && y2 < height) {
			g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
		}
	}
	
	protected void drawExample(Graphics g) {
		int w = width/2;
		int h = height/2;

		Example ex = new Example(1, 4, 60, 1000000);
		
		ex.paint((i, line)->{
			int k = i%7;
			g.setColor(RAIN_BOW[k]);
			
			drawDot(line.getX1(), line.getY1(), w, h);
		});	
	}
	
	protected void drawCantor(Graphics g) {
		Cantor cantor = new Cantor(10, 10, width-10, 10, 50);
		
		cantor.paint(LINE_PAINTER);
	}
	
	protected void drawKochSnowflake(Graphics g) {
		g.setColor(Color.YELLOW);
		int i=10;
		KochSnowflake snowflake = new KochSnowflake(280, 10, 164.5, 210.0, i);
		
		snowflake.paint(LINE_PAINTER);		
		
		snowflake = new KochSnowflake(164.5, 210, 395.5, 210.0, i);
		
		snowflake.paint(LINE_PAINTER);
		
		snowflake = new KochSnowflake(395.5, 210, 280, 10, i);
		
		snowflake.paint(LINE_PAINTER);				
	}
	
	protected void drawKoch(Graphics g) {
		g.setColor(Color.YELLOW);
		int i=2;
		
		Koch koch = new Koch(100, 0, 1780, 0, i);
		koch.paint(LINE_PAINTER);
	}
}
