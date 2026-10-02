package fr.univamu.geometry;

import java.util.List;

public record ArbitraryPolygon(List<Vector2D> vertices) implements Polygon {
  public ArbitraryPolygon {
    if (vertices.size() < 3) {
      throw new IllegalArgumentException("Un polygone a au moins 3 sommets");
    }
    vertices = List.copyOf(vertices); // copie défensive : le record reste immuable
  }
}
