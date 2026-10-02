package fr.univamu.geometry;

import java.util.ArrayList;
import java.util.List;

public record RegularPolygon(Vector2D center, double radius, int sides) implements Polygon {

  public RegularPolygon {
    if (sides < 3) {
      throw new IllegalArgumentException("Un polygone régulier a au moins 3 côtés");
    }
  }

  @Override
  public List<Vector2D> vertices() {
    List<Vector2D> vertices = new ArrayList<>();
    for (int i = 0; i < sides; i++) {
      vertices.add(center.add(Vector2D.polar(radius, 2 * Math.PI * i / sides)));
    }
    return vertices;
  }
}
