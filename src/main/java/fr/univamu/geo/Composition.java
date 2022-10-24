package fr.univamu.geo;

import java.util.List;

public record Composition(List<Transformation> transforms) implements Transformation {
  @Override
  public String toTag() {
    StringBuilder builder = new StringBuilder();
    for (Transformation transformation : transforms) {
      builder.append(transformation.toTag()).append(" ");
    }
    return builder.toString();
  }
}
