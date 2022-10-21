package fr.univamu.geo;


public record Regular(int nbVertices) implements Polygon {

  @Override
  public Vector2D getVertex(int index) {
    return Vector2D.polar(index * 2 * Math.PI / nbVertices(), 1);
  }


}
