package com.proyecto.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.app.commons.GenericService;
import com.proyecto.app.models.Servicio;
import com.proyecto.app.repository.ServicioRepository;
import com.proyecto.app.service.ServicioService;

@Service
public class ServicioServiceImpl extends GenericService<Servicio, Integer> implements ServicioService {

	
	@Autowired
	private ServicioRepository ServicioRepository;
	
	@Override
	public CrudRepository<Servicio, Integer> getDao() {
		return ServicioRepository;
	}

}
