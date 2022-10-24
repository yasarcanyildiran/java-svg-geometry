package fr.univamu.geo;

public record Rotation(double angle) implements Transformation {


  @Override
  public String toTag() {
    return "rotate(" + angle * 180 / Math.PI + ")";
  }
}
