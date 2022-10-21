package fr.univamu.geo;


public record Star(int nbVertices, int step) implements Polygon {

  @Override
  public Vector2D getVertex(int index) {
    return Vector2D.polar(step * index * 2 * Math.PI / nbVertices(), 1);
  }

}
