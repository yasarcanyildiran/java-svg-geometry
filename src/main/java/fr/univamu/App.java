package fr.univamu;

import fr.univamu.geometry.*;
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
    // Tâche 2 : formes de base
    App.makeSvg(new Circle(5)).toFile("out/circle.svg");

    // Figure 1 du sujet : polygone régulier + deux étoiles
    Shape figure1 = Group.of(
        new RegularPolygon(new Vector2D(-6, 0), 3, 7),
        new Star(Vector2D.ZERO, 3, 5, 2),
        new Star(new Vector2D(6, 0), 3, 9, 4)
    ).fill("lightgray").stroke("black", 0.1);
    App.makeSvg(figure1).toFile("out/stars.svg");

    // Tâche 3 + 4 : un groupe transformé (composition de transformations)
    Shape square = Polygon.of(
        new Vector2D(0, 0), new Vector2D(2, 0), new Vector2D(2, 2), new Vector2D(0, 2));
    Shape demo = Group.of(square.fill("orange"), new Circle(1).fill("purple"))
        .translate(new Vector2D(3, 0))
        .rotate(45)
        .scale(1.5);
    App.makeSvg(demo).toFile("out/demo.svg");
  }
}
