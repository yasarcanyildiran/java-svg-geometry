package fr.univamu.geo;

import fr.univamu.svg.SvgElement;

import java.util.List;

public sealed interface Shape
  permits Disc, Polygon, Transformed, Group {

  SvgElement toSvg();

  default Shape transform(Transformation transform) {
    return new Transformed(this, transform);
  }

  default Shape translate(Vector2D move) {
    return this.transform(new Translation(move));
  }

  default Shape translate(double x, double y) {
    return this.translate(new Vector2D(x,y));
  }

  default Shape rotate(double radian) {
    return this.transform(new Rotation(radian));
  }

  default Shape rotate(double radian, Vector2D center) {
    return this.transform(new Composition(
        List.of(
            new Translation(center),
            new Rotation(radian),
            new Translation(center.opposite())
        )
    ));
  }

  default Shape scale(double xFactor, double yFactor) {
    return this.transform(new Scale(xFactor, yFactor));
  }

  default Shape scale(double factor) {
    return this.scale(factor,factor);
  }

}
