package fr.univamu.geo;

import fr.univamu.svg.SvgElement;

public sealed interface Shape
  permits Disc, Polygon {

  SvgElement toSvg();
}
