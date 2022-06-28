package com.springboot.app.paises.models.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.paises.models.entity.Pais;
import com.springboot.app.paises.models.entity.PaisDTO;

@Service
public class PaisServiceImp implements IPaisService{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	@Transactional(readOnly = true)
	public List<PaisDTO> findAll() {
		List<Pais> paises = Arrays.asList( clienteRest.getForObject("https://restcountries.com/v3.1/all", Pais[].class) );
		return paises.stream()
				.map(p -> new PaisDTO (p.getName().getCommon(), p.getName().getOfficial(), p.getRegion(), p.getSubregion()))
				.collect(Collectors.toList());
		
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Collection<PaisDTO> findAllById(String regionName) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("region", regionName);
		List<Pais> paises = new ArrayList<Pais>();
		
		try {
		    // Se capturan las excepciones que se puedan generar al hacer la busqueda por región. Ejemplo: Busqueda de una región que no exista. 
			paises = Arrays.asList( clienteRest.getForObject("https://restcountries.com/v3.1/region/{region}", Pais[].class, pathVariables) );
		} catch (Exception e) {
			
		}
		
		return paises.stream()
				.map(p -> new PaisDTO (p.getName().getCommon(), p.getName().getOfficial(), p.getRegion(), p.getSubregion()))
				.collect(Collectors.toList());
	}

}
