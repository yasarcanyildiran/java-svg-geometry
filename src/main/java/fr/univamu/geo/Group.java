package fr.univamu.geo;

import fr.univamu.svg.SvgElement;

import java.util.List;

public record Group(List<Shape> shapes) implements Shape {

  @Override
  public SvgElement toSvg() {
    SvgElement group = new SvgElement("g");
    for (Shape shape : shapes) {
      group.add(shape.toSvg());
    }
    return group;
  }

}
