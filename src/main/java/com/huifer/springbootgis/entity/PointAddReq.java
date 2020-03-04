package com.huifer.springbootgis.entity;

public class PointAddReq extends BaseGeom {
	private Integer id;

	private String name;


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


	public String getGeoHash() {
		return geoHash;
	}

	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}
}