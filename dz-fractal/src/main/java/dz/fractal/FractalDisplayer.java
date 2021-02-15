package dz.fractal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import dz.fractal.recursive.Example;

public class FractalDisplayer {
	private final static Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75,0,130), new Color(102,0,153)}; 
	
	public static void main(String[] args) {
		FractalDisplayer d = new FractalDisplayer();
		d.show();
	}
	
	protected JFrame createFrame() {
		JFrame f = new JFrame();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setUndecorated(true);		
		f.setVisible(true);
		f.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		return f;
	}

	protected void drawDot(Graphics g, double x, double y, int w, int h, int width, int height) {
		if (x+w<width && y+h<height) {
			g.drawLine((int) (x) + w, (int) (y) + h, (int) (x) + w, (int) (y) + h);				
		}
	}
	
	public void show() {
		JFrame f = createFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int w = screenSize.width/2;
		int h = screenSize.height/2;

		Graphics g = f.getGraphics();
		
		Example ex = new Example(1, 4, 60, 1000000);
		
		ex.paint(dot->{
			int k = dot.getIndex()%7;
			g.setColor(colors[k]);
			
			drawDot(g, dot.getX(), dot.getY(), w, h, screenSize.width, screenSize.height);
		});
	}	
}