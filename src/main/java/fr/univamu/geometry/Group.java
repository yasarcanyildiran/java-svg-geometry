package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.List;

/** Tâche 4 : union de formes, traduite en élément SVG <g>. */
public record Group(List<Shape> shapes) implements Shape {

  public Group {
    shapes = List.copyOf(shapes);
  }

  public static Group of(Shape... shapes) {
    return new Group(List.of(shapes));
  }

  @Override
  public SvgElement toSvg() {
    SvgElement g = new SvgElement("g");
    for (Shape shape : shapes) {
      g.add(shape.toSvg());
    }
    return g;
  }
}
