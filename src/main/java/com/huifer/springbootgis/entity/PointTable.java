package com.huifer.springbootgis.entity;

public class PointTable {
	private Integer id;

	private String name;

	private String geom;

	private String geoHash;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public String getGeoHash() {
		return geoHash;
	}

	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}
}