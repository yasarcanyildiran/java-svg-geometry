package fr.univamu.geometry;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class ShapeTest {

  @Test
  void testCircleToSvg() {
    String svg = new Circle(1).toSvg().toString();
    assertThat(svg).startsWith("<circle").contains("r=\"1.0\"", "cx=\"0.0\"", "cy=\"0.0\"");
  }

  @Test
  void testPolygonToSvg() {
    Polygon p = Polygon.of(new Vector2D(0, 0), new Vector2D(3, 0), new Vector2D(3, 1));
    assertThat(p.toSvg().toString()).contains("points=\"0.0,0.0 3.0,0.0 3.0,1.0\"");
  }

  @Test
  void testRegularPolygonHasRightNumberOfVertices() {
    assertThat(new RegularPolygon(Vector2D.ZERO, 1, 6).vertices()).hasSize(6);
  }

  @Test
  void testRegularPolygonVerticesAreOnTheCircle() {
    Vector2D center = new Vector2D(2, 3);
    for (Vector2D v : new RegularPolygon(center, 4, 7).vertices()) {
      assertThat(v.subtract(center).norm()).isCloseTo(4, within(1e-9));
    }
  }

  @Test
  void testStarHasRightNumberOfVertices() {
    assertThat(new Star(Vector2D.ZERO, 1, 5, 2).vertices()).hasSize(5);
  }
}
