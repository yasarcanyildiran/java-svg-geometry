package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.List;

public sealed interface Shape permits Circle, Polygon, Group, Transformed {

  SvgElement toSvg();

  // ---- Tâche 3 : transformations (méthodes par défaut) ----

  default Shape transform(Transformation transformation) {
    return new Transformed(this, List.of(transformation));
  }

  default Shape translate(Vector2D vector) {
    return transform(new Transformation.Translation(vector));
  }

  default Shape rotate(double degrees, Vector2D center) {
    return transform(new Transformation.Rotation(degrees, center));
  }

  default Shape rotate(double degrees) {
    return rotate(degrees, Vector2D.ZERO);
  }

  default Shape scale(double sx, double sy) {
    return transform(new Transformation.Scaling(sx, sy));
  }

  default Shape scale(double factor) {
    return scale(factor, factor);
  }
}
