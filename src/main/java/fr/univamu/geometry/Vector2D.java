package fr.univamu.geometry;

/** Vecteur du plan, immuable (record). */
public record Vector2D(double x, double y) {

  public static final Vector2D ZERO = new Vector2D(0, 0);
  public static final Vector2D UNIT_X = new Vector2D(1, 0);
  public static final Vector2D UNIT_Y = new Vector2D(0, 1);

  public static Vector2D cartesian(double x, double y) {
    return new Vector2D(x, y);
  }

  public static Vector2D polar(double radius, double radian) {
    return new Vector2D(radius * Math.cos(radian), radius * Math.sin(radian));
  }

  public Vector2D add(Vector2D other) {
    return new Vector2D(x + other.x, y + other.y);
  }

  public Vector2D subtract(Vector2D other) {
    return new Vector2D(x - other.x, y - other.y);
  }

  public Vector2D opposite() {
    return new Vector2D(-x, -y);
  }

  public Vector2D multiply(double scalar) {
    return new Vector2D(scalar * x, scalar * y);
  }

  public double dot(Vector2D other) {
    return x * other.x + y * other.y;
  }

  public double norm() {
    return Math.sqrt(dot(this));
  }

  public Vector2D rotate(double radian) {
    double cos = Math.cos(radian);
    double sin = Math.sin(radian);
    return new Vector2D(cos * x - sin * y, sin * x + cos * y);
  }

  /** Format utilisé par l'attribut SVG "points" : "x,y". */
  public String toSvgPoint() {
    return x + "," + y;
  }
}
