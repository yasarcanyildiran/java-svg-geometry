package fr.univamu.geo;

public record Scale(double xFactor, double yFactor) implements Transformation {
  @Override
  public String toTag() {
    return "scale(" + xFactor + "," + yFactor + ")";
  }
}
