package dz.fractal.recursive;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Koch {
	private static final double PI = 3.14159;
	private static final double SIXTY_DEGREE = PI/3;
	private final double ax, ay, bx, by;
	private final int minLength;	
	
	public void paint(Consumer<Line2D> painter) {
		drawLine(ax, ay, bx, by, minLength, painter);
	}
	
	protected void drawLine(double ax, double ay, double bx, double by, int minLength, Consumer<Line2D> painter) {
		double cx, cy, dx, dy, ex, ey, l, alpha;
		
		if ( (bx-ax)*(bx-ax) + (by-ay)*(by-ay) < minLength) {
			painter.accept(new Double(ax, 500-(int)ay, bx, 500-(int)by));
		}else {
			cx = ax + (bx-ax)/3;
			cy = ay + (by-ay)/3;
			ex = bx - (bx-ax)/3;
			ey = by - (by-ay)/3;
			
			l = Math.sqrt((ex-cx)*(ex-cx) + (ey-cy)*(ey-cy));
			alpha = Math.atan((ey-cy)/(ex-cx));
			
			if (ex-cx<0) {
				alpha += PI;
			}
			
			dy = cy + Math.sin(alpha + SIXTY_DEGREE) * l;
			dx = cx + Math.cos(alpha + SIXTY_DEGREE) * l;
			
			drawLine(ax, ay, cx, cy, minLength, painter);
			drawLine(ex, ey, bx, by, minLength, painter);
			drawLine(cx, cy, dx, dy, minLength, painter);
			drawLine(dx, dy, ex, ey, minLength, painter);
		}
	}	
}
