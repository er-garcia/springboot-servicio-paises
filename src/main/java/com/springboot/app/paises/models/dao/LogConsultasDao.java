package com.springboot.app.paises.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.paises.models.entity.LogConsultas;

public interface LogConsultasDao extends CrudRepository<LogConsultas, Long>{
	
}
