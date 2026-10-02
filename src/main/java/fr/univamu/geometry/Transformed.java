package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.ArrayList;
import java.util.List;

import static fr.univamu.svg.SvgAttribute.tag;

/**
 * Forme à laquelle on applique une suite de transformations,
 * dans l'ordre de la liste (la première est appliquée en premier).
 */
public record Transformed(Shape shape, List<Transformation> transformations) implements Shape {

  public Transformed {
    transformations = List.copyOf(transformations);
  }

  /** Composition : au lieu d'imbriquer, on ajoute à la liste. */
  @Override
  public Shape transform(Transformation transformation) {
    List<Transformation> all = new ArrayList<>(transformations);
    all.add(transformation);
    return new Transformed(shape, all);
  }

  @Override
  public SvgElement toSvg() {
    // En SVG, "A B" applique B d'abord puis A : on écrit donc la liste à l'envers.
    StringBuilder value = new StringBuilder();
    for (int i = transformations.size() - 1; i >= 0; i--) {
      value.append(transformations.get(i).toSvg());
      if (i > 0) {
        value.append(" ");
      }
    }
    return shape.toSvg().add(tag("transform", value.toString()));
  }
}
