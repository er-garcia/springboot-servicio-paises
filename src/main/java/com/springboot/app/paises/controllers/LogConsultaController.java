package com.springboot.app.paises.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.paises.models.entity.LogConsultas;
import com.springboot.app.paises.models.service.ILogConsultasService;

@RestController
public class LogConsultaController {
	
	@Autowired
	private ILogConsultasService logConsultasService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogConsultaController.class);
	
	@PostMapping("/api/v1/CrearLog")
	@Cacheable("addresses")
	@ResponseStatus(HttpStatus.CREATED)
	public LogConsultas crearLog(@RequestBody @Validated LogConsultas log/*,  
			@RequestHeader("host") String host,
			@RequestHeader("Content-Type") String codificacion*/) {
		//System.out.println("IP Origen: "+ host);
		//System.out.println("Fecha hora: "+ codificacion);
		return logConsultasService.save(log);
	}

	@GetMapping("/ObtenerLog/")
	@Cacheable("addresses")
    public LogConsultas getLog() {
		LOGGER.debug("getLog() - START");
        return new LogConsultas();
    }
    
	
}
