package fr.univamu.geo;

import fr.univamu.svg.SvgElement;

import static fr.univamu.svg.SvgAttribute.tag;

public record Disc(double radius, Vector2D center) implements Shape {

  @Override
  public SvgElement toSvg() {
    return new SvgElement("circle")
        .add(tag("r", radius))
        .add(tag("cx", center.x()))
        .add(tag("cy", center.y()));
  }

}
