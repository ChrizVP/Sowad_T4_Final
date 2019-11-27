package com.proyecto.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.app.commons.GenericService;
import com.proyecto.app.models.ServicioMecanicoCab;
import com.proyecto.app.repository.ServicioMecanicoCabRepository;
import com.proyecto.app.service.ServicioMecanicoCabService;

@Service
public class ServicioMecanicoCabServiceImpl extends GenericService<ServicioMecanicoCab, Integer> implements ServicioMecanicoCabService{

	@Autowired
	private ServicioMecanicoCabRepository CabProductoRepository;
	
	@Override
	public CrudRepository<ServicioMecanicoCab, Integer> getDao() {
		
		return CabProductoRepository;
	}
}
