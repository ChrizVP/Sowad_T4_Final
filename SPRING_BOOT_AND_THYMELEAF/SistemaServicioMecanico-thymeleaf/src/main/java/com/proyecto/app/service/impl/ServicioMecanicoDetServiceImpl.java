package com.proyecto.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.app.commons.GenericService;
import com.proyecto.app.models.ServicioMecanicoDet;
import com.proyecto.app.repository.ServicioMecanicoDetRepository;
import com.proyecto.app.service.ServicioMecanicoDetService;

@Service
public class ServicioMecanicoDetServiceImpl extends GenericService<ServicioMecanicoDet, Integer> implements ServicioMecanicoDetService{

	@Autowired
	private ServicioMecanicoDetRepository ServicioMecanicoDetRepository;
	
	@Override
	public CrudRepository<ServicioMecanicoDet, Integer> getDao() {
		
		return ServicioMecanicoDetRepository;
	}

}
