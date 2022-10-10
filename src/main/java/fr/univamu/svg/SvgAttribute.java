package fr.univamu.svg;

public interface SvgAttribute {

  String name();
  String stringValue();

  default String asSvg() {
    return name() + "=\"" + stringValue() + "\"";
  }

  static SvgAttribute tag(String name, String value) {
    return new Tag(name, value);
  }

  static SvgAttribute tag(String name, double value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, int value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, boolean value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, float value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, long value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, char value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, short value) {
    return new Tag(name, String.valueOf(value));
  }
  static SvgAttribute tag(String name, byte value) {
    return new Tag(name, String.valueOf(value));
  }

  static SvgAttribute tag(String name, Object value) {
    return new Tag(name, value.toString());
  }
}
