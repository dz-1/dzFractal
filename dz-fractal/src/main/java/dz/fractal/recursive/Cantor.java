package dz.fractal.recursive;

import java.awt.Point;
import java.util.function.Consumer;

import dz.fractal.model.Line;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cantor {
	private static final double MIN_LENGTH=1;
	private final double ax, ay, bx, by;
	private final int lineHeight;
	
	public void paint(Consumer<Line> painter) {
		drawLine(ax, ay, bx, by, painter);
	}
	
	protected void drawLine(double ax, double ay, double bx, double by, Consumer<Line> painter) {
		if (bx-ax<MIN_LENGTH) {
			painter.accept(Line.builder().start(new Point((int)ax, (int)ay)).end(new Point ((int)bx, (int)by)).build());
		}else {
			double cx, cy, dx, dy;
			
			painter.accept(Line.builder().start(new Point((int)ax, (int)ay)).end(new Point ((int)bx, (int)by)).build());
			
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
