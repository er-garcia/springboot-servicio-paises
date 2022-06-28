package com.springboot.app.paises.models.entity;

import java.io.Serializable;

public class DetallePais implements Serializable{
	
	
	private String common;
	private String official;

	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}

	private static final long serialVersionUID = -6918545938511184126L;

}
