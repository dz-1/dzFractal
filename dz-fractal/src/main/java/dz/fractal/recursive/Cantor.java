package dz.fractal.recursive;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cantor {
	private static final double MIN_LENGTH=1;
	private final double ax, ay, bx, by;
	private final int lineHeight;
	
	public void paint(Consumer<Line2D> painter) {
		drawLine(ax, ay, bx, by, painter);
	}
	
	protected void drawLine(double ax, double ay, double bx, double by, Consumer<Line2D> painter) {
		if (bx-ax<MIN_LENGTH) {
			painter.accept(new Double(ax, ay, bx, by));
		}else {
			double cx, cy, dx, dy;
			painter.accept(new Double(ax, ay, bx, by));
			
			double span = (bx-ax)/3;
			
			cx = ax + span;
			cy = ay + lineHeight;
			dx = bx - span;
			dy = by + lineHeight;
			ay = ay + lineHeight;
			by = by + lineHeight;
			
			drawLine(ax, ay, cx, cy, painter);
			drawLine(dx, dy, bx, by, painter);
		}
	}
}
