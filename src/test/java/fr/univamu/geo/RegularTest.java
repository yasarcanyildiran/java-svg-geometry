package fr.univamu.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularTest {

  @Test
  void toSvg() {
    assertEquals(
        "<polygon points=\"1.0,0.0 -0.4999999999999998,0.8660254037844387 -0.5000000000000004,-0.8660254037844384 \"/>\n"
        , new Regular(3).toSvg().toString());
    assertEquals(
        "<polygon points=\"1.0,0.0 6.123233995736766E-17,1.0 -1.0,1.2246467991473532E-16 -1.8369701987210297E-16,-1.0 \"/>\n"
        , new Regular(4).toSvg().toString());
  }
}