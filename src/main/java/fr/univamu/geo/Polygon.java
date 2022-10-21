package fr.univamu.geo;

import fr.univamu.svg.SvgAttribute;
import fr.univamu.svg.SvgElement;

public sealed interface Polygon extends Shape
  permits Regular, Star, Arbitrary {

  int nbVertices();
  Vector2D getVertex(int index);

  @Override
  default SvgElement toSvg() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < nbVertices(); i++) {
      builder.append(getVertex(i)).append(" ");
    }
    return new SvgElement("polygon")
        .add(SvgAttribute.tag("points", builder.toString()));
  }
}
