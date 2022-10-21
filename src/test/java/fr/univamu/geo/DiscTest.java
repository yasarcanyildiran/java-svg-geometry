package fr.univamu.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscTest {

  @Test
  void toSvg() {
    assertEquals("<circle r=\"1.0\" cx=\"0.0\" cy=\"0.0\"/>\n",
        new Disc(1,Vector2D.ZERO).toSvg().toString()
    );
    assertEquals("<circle r=\"0.5\" cx=\"3.0\" cy=\"-2.0\"/>\n",
        new Disc(0.5,Vector2D.cartesian(3,-2)).toSvg().toString()
    );
  }
}