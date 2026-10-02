package fr.univamu.geometry;

import fr.univamu.svg.SvgElement;

public sealed interface Shape permits Circle, Polygon {

  SvgElement toSvg();
}
