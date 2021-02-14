package dz.fractal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	private double x1 = 0, y1 = 0;
	private double x = 0, y = 0;

	public static void main(String[] args) {
		Main d = new Main();
		d.initUI();
	}

	public void initUI() {
		JFrame f = new JFrame();
		Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75,0,130), new Color(102,0,153)};

		//f.setTitle("DZ-Fractal");
		//f.setSize(700, 700);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setUndecorated(true);		
		f.setVisible(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int w = screenSize.width/2;
		int h = screenSize.height/2;

		Graphics g = f.getGraphics();

		//double a = 0.4, b = 1, c = 0;
		
		for (int j = 0; j < 100; ++j) {
			for (int i = 0; i < 100000; i++) {
				int k = i%7;
				g.setColor(colors[k]);
				
				x = y1 - Math.signum(x1) * Math.sqrt(Math.abs(4 * x1 - 60));
				y = 1 - x1;

				drawDot(g, x, y, w, h, screenSize.width, screenSize.height);
				
				x1 = x;
				y1 = y;
			}
		}
		 

		/*
		for (int i = 0; i < 50000; ++i) {
			g.setColor(Color.BLUE);
			x = Math.sin(-2 * y1) - Math.cos(-2 * x1);
			y = Math.sin(-1.2 * x1) - Math.cos(2 * y1);
			g.drawLine((int) (80 * x) + 200, (int) (80 * y) + 300, (int) (80 * x) + 200, (int) (80 * y) + 300);

			x1 = x;
			y1 = y;
		}
		*/
		 
	}
	
	private void drawDot(Graphics g, double x, double y, int w, int h, int width, int height) {
		if (x+w<width && y+h<height) {
			g.drawLine((int) (x) + w, (int) (y) + h, (int) (x) + w, (int) (y) + h);				
		}
	}
}