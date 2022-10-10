package fr.univamu.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SvgElement {

  private final String name;
  private final Map<String, SvgAttribute> attributes = new HashMap<>();
  private final List<SvgElement> children = new ArrayList<>();

  public SvgElement(String name) {
    this.name = name;
  }

  public SvgElement add(SvgAttribute attribute) {
    attributes.put(attribute.name(),attribute);
    return this; // allows chaining of adds
  }

  public List<SvgElement> children() {
    return children;
  }

  public SvgElement add(SvgElement svgElement) {
    this.children.add(svgElement);
    return this; // allows chaining of adds
  }

  public void toFile(String filepath) throws FileNotFoundException {
    try (PrintStream out = new PrintStream(filepath)) {
      out.println(this);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    this.appendTo(builder,0);
    return builder.toString();
  }

  private void appendTo(StringBuilder builder, int indentation) {
    builder.append("  ".repeat(indentation)).append("<").append(name);
    attributes.values().forEach(attribute ->
        builder.append(" ").append(attribute.asSvg())
    );
    if (children.isEmpty()) {
      builder.append("/>\n");
    } else {
      builder.append(">\n");
      children.forEach(child -> child.appendTo(builder,indentation+1));
      builder.append("  ".repeat(indentation)).append("</").append(name).append(">\n");
    }
  }



}
