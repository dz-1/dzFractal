package dz.fractal.recursive;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KochSnowflake {
	private static final double SQRT_3 = Math.sqrt(3);
	private final double x1, y1, x2, y2;
	private final int depth;	

	public void paint(Consumer<Line2D> painter) {
		drawSnowflake(x1, y1, x2, y2, depth, painter);
	}
	
	protected void drawSnowflake(double x1, double y1, double x2, double y2, int depth, Consumer<Line2D> painter) {
		if (depth <= 1) {
			painter.accept(new Double(x1, y1, x2, y2));
		}else {
			double x4 = x1*2/3 + x2*1/3;
			double y4 = y1*2/3 + y2*1/3;
			double x5 = x1*1/3 + x2*2/3;
			double y5 = y1*1/3 + y2*2/3;
			double x6 = (x4+x5)/2 + (y4-y5)*SQRT_3/2;
			double y6 = (y4+y5)/2 + (x5-x4)*SQRT_3/2;
			
			drawSnowflake(x1, y1, x4, y4, depth-1, painter);
			drawSnowflake(x4, y4, x6, y6, depth-1, painter);
			drawSnowflake(x6, y6, x5, y5, depth-1, painter);
			drawSnowflake(x5, y5, x2, y2, depth-1, painter);
		}
	}
}
