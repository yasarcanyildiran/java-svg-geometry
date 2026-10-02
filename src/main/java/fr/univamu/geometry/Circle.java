package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import static fr.univamu.svg.SvgAttribute.tag;

public record Circle(Vector2D center, double radius) implements Shape {

  public Circle(double radius) {
    this(Vector2D.ZERO, radius);
  }

  @Override
  public SvgElement toSvg() {
    return new SvgElement("circle")
        .add(tag("r", radius))
        .add(tag("cx", center.x()))
        .add(tag("cy", center.y()));
  }
}
