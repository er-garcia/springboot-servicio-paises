package com.springboot.app.paises.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.paises.models.dao.LogConsultasDao;
import com.springboot.app.paises.models.entity.LogConsultas;

@Service
public class LogConsultasServiceImp implements ILogConsultasService {

	@Autowired
	private LogConsultasDao logDao;
	
	@Override
	@Transactional
	public LogConsultas save(LogConsultas log) {
		return logDao.save(log);
	}

	@Override
	public List<LogConsultas> findAll() {
		return (List<LogConsultas>) logDao.findAll();
	}


}
