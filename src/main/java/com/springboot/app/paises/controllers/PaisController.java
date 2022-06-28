package com.springboot.app.paises.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.paises.models.entity.LogConsultas;
import com.springboot.app.paises.models.entity.PaisDTO;
import com.springboot.app.paises.models.service.ILogConsultasService;
import com.springboot.app.paises.models.service.IPaisService;

@RestController
public class PaisController {

	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ILogConsultasService logConsultasService;
	
	@GetMapping(value ="/api/v1/countries")
	@Cacheable("addresses")
    @ResponseBody
    public List<PaisDTO> listarPaises(HttpServletRequest request, HttpServletResponse requestH){
		
		String endpiont = request.getRequestURI();
		String remoteAddr = request.getRemoteAddr();
		Date date = new Date();
		LogConsultas log = new LogConsultas(
				date, 
				date, 
				endpiont, 
				remoteAddr
				);
		logConsultasService.save(log);
		return paisService.findAll();	 
	
	}	

 
	@GetMapping("/api/v1/countries/{regionName}")
	@Cacheable("addresses")
	public Collection<PaisDTO> detallePais(@RequestBody @Validated @PathVariable String regionName, 
			@RequestHeader("host") String host,
			HttpServletRequest request) {
		
		String endpiont = request.getRequestURI(); 
		Date date = new Date();
		LogConsultas log = new LogConsultas(
				date, 
				date, 
				endpiont, 
				host
				);
		logConsultasService.save(log);
		return paisService.findAllById(regionName);
	
	}
	
	
}
