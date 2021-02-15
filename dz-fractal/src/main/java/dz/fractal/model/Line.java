package dz.fractal.model;

import java.awt.Point;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Line {
	private Point start;
	private Point end;
}
