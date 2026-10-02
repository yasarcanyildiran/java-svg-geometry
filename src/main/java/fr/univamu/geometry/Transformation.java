package fr.univamu.geometry;

/** Une transformation affine élémentaire, traduite en fragment de l'attribut SVG "transform". */
public sealed interface Transformation
    permits Transformation.Translation, Transformation.Rotation, Transformation.Scaling {

  String toSvg();

  record Translation(Vector2D vector) implements Transformation {
    public String toSvg() {
      return "translate(" + vector.x() + "," + vector.y() + ")";
    }
  }

  /** Rotation d'un angle (en degrés, comme en SVG) autour d'un centre. */
  record Rotation(double degrees, Vector2D center) implements Transformation {
    public String toSvg() {
      return "rotate(" + degrees + "," + center.x() + "," + center.y() + ")";
    }
  }

  record Scaling(double sx, double sy) implements Transformation {
    public String toSvg() {
      return "scale(" + sx + "," + sy + ")";
    }
  }
}
