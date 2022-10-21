package fr.univamu.geo;

public record Vector2D(double x, double y) {

  public static final Vector2D ZERO = new Vector2D(0,0);
  public static final Vector2D I = new Vector2D(1,0);
  public static final Vector2D J = new Vector2D(0,1);
  private static final double EPSILON = 1e-9;

  @Override
  public String toString() {
    return this.x + "," + this.y;
  }

  public static Vector2D cartesian(double x, double y) {
    return new Vector2D(x, y);
  }

  public static Vector2D polar(double radian, double radius) {
    return new Vector2D(
        Math.cos(radian) * radius,
        Math.sin(radian) * radius
    );
  }

  public Vector2D plus(Vector2D vec) {
    return new Vector2D(this.x + vec.x, this.y + vec.y);
  }

  public Vector2D minus(Vector2D vec) {
    return new Vector2D(this.x - vec.x, this.y - vec.y);
  }

  public Vector2D opposite() {
    return new Vector2D(-this.x, -this.y);
  }

  public Vector2D scale(double factor) {
    return new Vector2D(factor * this.x, factor * this.y);
  }

  public double dot(Vector2D vec) {
    return this.x * vec.x + this.y * vec.y;
  }

  public Vector2D rotate(double radian) {
    return new Vector2D(
        Math.cos(radian) * this.x - Math.sin(radian) * this.y,
        Math.sin(radian) * this.x + Math.cos(radian) * this.y
    );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) { return true; }
    if (!(o instanceof Vector2D vec)) {
      return false;
    }
    return Math.abs(this.x - vec.x) < EPSILON
        && Math.abs(this.y - vec.y) < EPSILON;
  }
}
