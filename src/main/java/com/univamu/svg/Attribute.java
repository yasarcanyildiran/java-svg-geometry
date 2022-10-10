package com.univamu.svg;

public interface Attribute {

  String name();
  String stringValue();

  default String asSvg() {
    return name() + "=\"" + stringValue() + "\"";
  }

  static Attribute tag(String name, String value) {
    return new Tag(name, value);
  }

  static Attribute tag(String name, double value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, int value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, boolean value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, float value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, long value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, char value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, short value) {
    return new Tag(name, String.valueOf(value));
  }
  static Attribute tag(String name, byte value) {
    return new Tag(name, String.valueOf(value));
  }

  static Attribute tag(String name, Object value) {
    return new Tag(name, value.toString());
  }
}
