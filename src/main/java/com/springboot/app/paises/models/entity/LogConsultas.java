package com.springboot.app.paises.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "logConsultas")
public class LogConsultas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "hora")
	@Temporal(TemporalType.TIME)
	private Date hourCreatedAt;

	private String endpoint;
	private String ipOrigen;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getHourCreatedAt() {
		return hourCreatedAt;
	}

	public void setHourCreatedAt(Date hourCreatedAt) {
		this.hourCreatedAt = hourCreatedAt;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getIpOrigen() {
		return ipOrigen;
	}

	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	
	public LogConsultas() {
	}

	public LogConsultas(Date createdAt, Date hourCreatedAt, String endpoint, String ipOrigen) {
		super();
		this.createdAt = createdAt;
		this.hourCreatedAt = hourCreatedAt;
		this.endpoint = endpoint;
		this.ipOrigen = ipOrigen;
	}


	private static final long serialVersionUID = -8357674656905483509L;

}
