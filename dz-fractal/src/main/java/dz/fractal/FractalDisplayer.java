package dz.fractal;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FractalDisplayer {
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBackground(Color.WHITE);
		
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      }); 
		
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		frame.setVisible(true);
	}
}