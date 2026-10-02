package fr.univamu.geometry;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class Vector2DTest {

  @Test
  void testAdd() {
    assertThat(new Vector2D(1, 2).add(new Vector2D(3, 4))).isEqualTo(new Vector2D(4, 6));
  }

  @Test
  void testSubtractAndOpposite() {
    assertThat(new Vector2D(1, 2).subtract(new Vector2D(3, 4))).isEqualTo(new Vector2D(-2, -2));
    assertThat(new Vector2D(1, -2).opposite()).isEqualTo(new Vector2D(-1, 2));
  }

  @Test
  void testMultiplyAndDot() {
    assertThat(new Vector2D(1, 2).multiply(3)).isEqualTo(new Vector2D(3, 6));
    assertThat(new Vector2D(1, 2).dot(new Vector2D(3, 4))).isEqualTo(11.0);
  }

  @Test
  void testRotate() {
    Vector2D rotated = Vector2D.UNIT_X.rotate(Math.PI / 2);
    assertThat(rotated.x()).isCloseTo(0, within(1e-9));
    assertThat(rotated.y()).isCloseTo(1, within(1e-9));
  }

  @Test
  void testPolar() {
    Vector2D v = Vector2D.polar(2, Math.PI);
    assertThat(v.x()).isCloseTo(-2, within(1e-9));
    assertThat(v.y()).isCloseTo(0, within(1e-9));
  }
}
