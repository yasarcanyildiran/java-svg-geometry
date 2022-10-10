package com.univamu.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

  private final String name;
  private final Map<String, Attribute> attributes = new HashMap<>();
  private final List<Node> children = new ArrayList<>();

  public Node(String name) {
    this.name = name;
  }

  public Node add(Attribute attribute) {
    attributes.put(attribute.name(),attribute);
    return this; // allows chaining of adds
  }

  public List<Node> children() {
    return children;
  }

  public Node add(Node node) {
    this.children.add(node);
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
