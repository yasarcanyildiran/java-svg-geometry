package fr.univamu.geo;

import java.util.List;

public record Arbitrary(List<Vector2D> vertices) implements Polygon {

  @Override
  public int nbVertices() {
    return vertices.size();
  }

  @Override
  public Vector2D getVertex(int index) {
    return vertices.get(index);
  }
}
