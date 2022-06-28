package com.springboot.app.paises.models.service;

import java.util.Collection;
import java.util.List;

import com.springboot.app.paises.models.entity.PaisDTO;

public interface IPaisService {
	
	public List<PaisDTO> findAll();	
	public Collection<PaisDTO> findAllById(String regionName);

}
