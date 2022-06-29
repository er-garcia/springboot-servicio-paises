package com.springboot.app.paises.models.service;

import java.util.List;

import com.springboot.app.paises.models.entity.LogConsultas;

public interface ILogConsultasService {
	
	public LogConsultas save(LogConsultas Log);
	public List<LogConsultas> findAll();	
}
