package fr.univamu;

import fr.univamu.geometry.Shape;
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



  public static void main(String[] args) throws FileNotFoundException {
    // Remplacer new Circle(1) par une expression de Shape de votre choix :
    // App.makeSvg(new Circle(1)).toFile("out/circle.svg");
  }
}
