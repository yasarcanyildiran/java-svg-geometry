package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.List;

public sealed interface Shape permits Circle, Polygon, Group, Transformed, Styled {

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

  // ---- Tâche 5 : style ----

  default Shape withStyle(String attribute, String value) {
    return Styled.of(this, attribute, value);
  }

  default Shape fill(String color) {
    return withStyle("fill", color);
  }

  default Shape stroke(String color, double width) {
    return withStyle("stroke", color).withStyle("stroke-width", String.valueOf(width));
  }

  default Shape opacity(double opacity) {
    return withStyle("opacity", String.valueOf(opacity));
  }
}
