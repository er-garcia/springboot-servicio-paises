package com.springboot.app.paises.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.paises.models.entity.LogConsultas;
import com.springboot.app.paises.models.service.ILogConsultasService;

@RestController
@RequestMapping("/api/v1")
public class LogConsultaController {
	
	@Autowired
	private ILogConsultasService logConsultasService;
	
	@PostMapping("/CrearLog")
	@Cacheable("addresses")
	@ResponseStatus(HttpStatus.CREATED)
	public LogConsultas crearLog(@RequestBody @Validated LogConsultas log) {
		return logConsultasService.save(log);
	}

	
	@GetMapping("/VerLog/")
	@Cacheable("addresses")
    public List<LogConsultas> listarLog() {
        return logConsultasService.findAll();
    }
    
}