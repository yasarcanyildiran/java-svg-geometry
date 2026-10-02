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

  @Test
  void testSingleTransformation() {
    String svg = new Circle(1).translate(new Vector2D(-3, 2)).toSvg().toString();
    assertThat(svg).contains("transform=\"translate(-3.0,2.0)\"");
  }

  @Test
  void testCompositionOfTransformations() {
    // translate puis scale  ->  en SVG : "scale(...) translate(...)"
    String svg = new Circle(1).translate(new Vector2D(1, 2)).scale(2).toSvg().toString();
    assertThat(svg).contains("transform=\"scale(2.0,2.0) translate(1.0,2.0)\"");
  }

  @Test
  void testRotationAroundCenter() {
    String svg = Polygon.of(new Vector2D(0, 0), new Vector2D(2, 2), new Vector2D(2, -2))
        .rotate(90, new Vector2D(1, 0)).toSvg().toString();
    assertThat(svg).contains("transform=\"rotate(90.0,1.0,0.0)\"");
  }

  @Test
  void testGroup() {
    String svg = Group.of(new Circle(1), new Circle(2)).toSvg().toString();
    assertThat(svg).startsWith("<g>").contains("r=\"1.0\"", "r=\"2.0\"").contains("</g>");
  }

  @Test
  void testTransformedGroup() {
    String svg = Group.of(new Circle(1), Polygon.of(new Vector2D(0, 0), new Vector2D(1, 0), new Vector2D(0, 1)))
        .translate(new Vector2D(2, 0)).toSvg().toString();
    assertThat(svg).startsWith("<g transform=\"translate(2.0,0.0)\">");
  }
}
