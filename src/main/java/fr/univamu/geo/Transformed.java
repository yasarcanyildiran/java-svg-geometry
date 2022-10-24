package fr.univamu.geo;

import fr.univamu.svg.SvgElement;

import java.util.List;

import static fr.univamu.svg.SvgAttribute.tag;

public record Transformed(Shape shape, Transformation transform) implements Shape {

  @Override
  public SvgElement toSvg() {
    return shape.toSvg().add(tag("transform", transform.toTag()));
  }

  @Override
  public Shape transform(Transformation transform) {
    return new Transformed(shape, new Composition(List.of(transform,this.transform)));
  }
}
