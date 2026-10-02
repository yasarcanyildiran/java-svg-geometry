package fr.univamu.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Polygone étoilé {branches/step} : on place `branches` points sur un cercle
 * et on les relie en sautant de `step` en `step`.
 */
public record Star(Vector2D center, double radius, int branches, int step) implements Polygon {

  public Star {
    if (branches < 5 || step < 2 || 2 * step >= branches) {
      throw new IllegalArgumentException("Paramètres d'étoile invalides");
    }
  }

  @Override
  public List<Vector2D> vertices() {
    List<Vector2D> vertices = new ArrayList<>();
    for (int i = 0; i < branches; i++) {
      double angle = 2 * Math.PI * ((long) i * step % branches) / branches - Math.PI / 2;
      vertices.add(center.add(Vector2D.polar(radius, angle)));
    }
    return vertices;
  }
}
