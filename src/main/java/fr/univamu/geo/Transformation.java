package fr.univamu.geo;

public sealed interface Transformation
  permits Rotation, Translation, Scale, Composition {

  String toTag();
}
