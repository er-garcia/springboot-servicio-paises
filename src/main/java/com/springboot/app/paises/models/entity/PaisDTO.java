package com.springboot.app.paises.models.entity;

import java.io.Serializable;

public class PaisDTO implements Serializable{
	
	
	private String commonName;
	private String officialName;
	private String region;
	private String subregion;
	
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getOfficialName() {
		return officialName;
	}
	public void setOfficialName(String officialName) {
		this.officialName = officialName;
	}
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
	
	public PaisDTO() {
	}
	public PaisDTO(String commonName, String officialName, String region, String subregion) {
		this.commonName = commonName;
		this.officialName = officialName;
		this.region = region;
		this.subregion = subregion;
	}

	private static final long serialVersionUID = 8630197291215301487L;
	
}
