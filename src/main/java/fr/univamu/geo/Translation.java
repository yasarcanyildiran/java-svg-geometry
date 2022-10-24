package fr.univamu.geo;

public record Translation(Vector2D move) implements Transformation {
  @Override
  public String toTag() {
    return "translate(" + move.x() + "," + move.y() + ")";
  }
}
