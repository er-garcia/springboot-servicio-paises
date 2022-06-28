package com.springboot.app.paises.models.entity;

import java.io.Serializable;

public class Pais implements Serializable{
	
	
	/*
	 * private String commonName; private String officialName;
	 */
	private String region;
	private String subregion;
	private DetallePais name;
	
	
	public Pais() {
	}
	public Pais(/*String commonName, String officialName,*/ String region, String subregion, DetallePais name) {
		/*
		 * this.commonName = commonName; this.officialName = officialName;
		 */
		this.region = region;
		this.subregion = subregion;
		this.name = name;
	}
	
	public DetallePais getName() {
		return name;
	}
	public void setName(DetallePais name) {
		this.name = name;
	}

	/*
	 * public String getCommonName() { return commonName; } public void
	 * setCommonName(String commonName) { this.commonName = commonName; } public
	 * String getOfficialName() { return officialName; } public void
	 * setOfficialName(String officialName) { this.officialName = officialName; }
	 */
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSubregion() {
		return subregion;
	}
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}
	
	private static final long serialVersionUID = -1924669265200924321L;

}
