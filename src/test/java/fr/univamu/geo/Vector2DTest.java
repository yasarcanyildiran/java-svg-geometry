package fr.univamu.geo;

import org.junit.jupiter.api.Test;

import static fr.univamu.geo.Vector2D.I;
import static fr.univamu.geo.Vector2D.J;
import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {

  @Test
  void plus() {
    assertEquals(Vector2D.cartesian(1,1), I.plus(J));
  }

  @Test
  void minus() {
    assertEquals(Vector2D.cartesian(1,-1), I.minus(J));
  }

  @Test
  void rotate() {
    assertEquals(J, I.rotate(Math.PI/2));
    assertEquals(I, J.rotate(-Math.PI/2));
  }
}