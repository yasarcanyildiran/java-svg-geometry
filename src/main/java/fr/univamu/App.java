package fr.univamu;

import fr.univamu.geo.Shape;
import fr.univamu.svg.SvgElement;

import java.io.FileNotFoundException;

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
    // write(new Circle(1),"out/circle.svg");
  }
}
