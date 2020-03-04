package com.huifer.springbootgis.entity;

public abstract class BaseGeom {
	private String geom;

	public boolean isPoint() {
		return this.geom.startsWith("point") || this.geom.startsWith("POINT");

	}

	public boolean isLine() {
		return this.geom.startsWith("linestring") || this.geom.startsWith("LINESTRING");
	}

	public boolean isPolygon() {
		return this.geom.startsWith("polygon") || this.geom.startsWith("POLYGON");
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}
}
