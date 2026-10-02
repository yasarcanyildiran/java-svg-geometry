package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.List;
import java.util.stream.Collectors;

import static fr.univamu.svg.SvgAttribute.tag;

public sealed interface Polygon extends Shape permits RegularPolygon, Star, ArbitraryPolygon {

  List<Vector2D> vertices();

  @Override
  default SvgElement toSvg() {
    String points = vertices().stream()
        .map(Vector2D::toSvgPoint)
        .collect(Collectors.joining(" "));
    return new SvgElement("polygon").add(tag("points", points));
  }

  static Polygon of(Vector2D... vertices) {
    return new ArbitraryPolygon(List.of(vertices));
  }
}
