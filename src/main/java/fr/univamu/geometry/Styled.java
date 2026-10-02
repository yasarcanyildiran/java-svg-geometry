package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

import java.util.LinkedHashMap;
import java.util.Map;

import static fr.univamu.svg.SvgAttribute.tag;

/** Tâche 5 : forme avec des attributs de présentation SVG (fill, stroke, opacity...). */
public record Styled(Shape shape, Map<String, String> style) implements Shape {

  public Styled {
    style = Map.copyOf(style);
  }

  static Styled of(Shape shape, String attribute, String value) {
    return new Styled(shape, Map.of(attribute, value));
  }

  /** Ajouter un style à une forme déjà stylée : on fusionne les deux maps. */
  @Override
  public Shape withStyle(String attribute, String value) {
    Map<String, String> merged = new LinkedHashMap<>(style);
    merged.put(attribute, value);
    return new Styled(shape, merged);
  }

  /** On pousse la transformation à l'intérieur, pour que Transformed puisse composer. */
  @Override
  public Shape transform(Transformation transformation) {
    return new Styled(shape.transform(transformation), style);
  }

  @Override
  public SvgElement toSvg() {
    SvgElement element = shape.toSvg();
    style.forEach((name, value) -> element.add(tag(name, value)));
    return element;
  }
}
