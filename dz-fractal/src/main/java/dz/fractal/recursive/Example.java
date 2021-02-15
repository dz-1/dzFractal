package dz.fractal.recursive;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.function.BiConsumer;

public class Example {
	private final int a, b, c, num;
	
	public Example(int a, int b, int c, int num) {
		this.a =a;
		this.b = b;
		this.c = c;
		this.num = num;
	}
	
	public void paint(BiConsumer<Integer, Line2D> painter) {
		double x = 0, y = 0;
		double x1 = 0, y1 = 0;
		
		for (int i = 0; i < num; i++) {
			x = y1 - Math.signum(x1) * Math.sqrt(Math.abs(b * x1 - c));
			y = a - x1;
	
			painter.accept(i, new Double(x, y, x, y));
			
			x1 = x;
			y1 = y;
		}
	}
}
