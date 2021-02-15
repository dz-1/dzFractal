package dz.fractal.recursive;

import java.util.function.Consumer;

import dz.fractal.model.Dot;

public class Example {
	private final int a, b, c, num;
	
	public Example(int a, int b, int c, int num) {
		this.a =a;
		this.b = b;
		this.c = c;
		this.num = num;
	}
	
	public void paint(Consumer<Dot> painter) {
		double x = 0, y = 0;
		double x1 = 0, y1 = 0;
		
		for (int i = 0; i < num; i++) {
			x = y1 - Math.signum(x1) * Math.sqrt(Math.abs(b * x1 - c));
			y = a - x1;
	
			painter.accept(Dot.builder().index(i).x(x).y(y).build());
			
			x1 = x;
			y1 = y;
		}
	}
}
