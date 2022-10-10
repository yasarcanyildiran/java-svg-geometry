package fr.univamu;

import fr.univamu.geo.Shape;
import fr.univamu.geo.Star;
import fr.univamu.geo.Union;

import java.util.List;

public class Shapes {

  public static Shape stars() {
    return new Union(List.of(
        new Star(5,2).scale(1.5),
        new Star(9,2).scale(1.5).translate(-4,0),
        new Star(9,4).scale(1.5).translate(4,0)
    ));
  }
}
