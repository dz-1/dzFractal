package dz.fractal.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Dot {
	private int index;
	private double x;
	private double y;
}
