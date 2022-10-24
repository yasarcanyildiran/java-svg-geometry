package fr.univamu;

import fr.univamu.geo.*;
import fr.univamu.svg.SvgElement;

import java.io.FileNotFoundException;
import java.util.List;

import static fr.univamu.svg.SvgAttribute.tag;

public class App {

  public static SvgElement makeSvg(Shape shape) {
    return new SvgElement("svg")
        .add(tag("viewBox","-10 -10 20 20"))
        .add(tag("xmlns","http://www.w3.org/2000/svg"))
        .add(shape.toSvg());
  }

  public static void write(Shape shape, String filepath) throws FileNotFoundException {
    makeSvg(shape)
//        .add(tag("stroke","black"))
//        .add(tag("stroke-width",0.03))
//        .add(tag("fill","lightgray"))
        .toFile(filepath);

  }

  public static void main(String[] args) throws FileNotFoundException {
    Shape shape1 = new Star(7, 3)
        .scale(3, 2)
        .rotate(Math.PI / 2)
        .translate(new Vector2D(5, -5))
        .rotate(Math.PI/4, new Vector2D(5,-5));
    Shape circle = new Disc(3, new Vector2D(-3,1));
    Group group1 = new Group(List.of(shape1, circle));
    Shape group2 = group1.rotate(Math.PI/6);
    write(new Group(List.of(group1,group2)),"out/group.svg");
  }
}
