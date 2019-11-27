package com.proyecto.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.app.commons.GenericService;
import com.proyecto.app.models.Personal;
import com.proyecto.app.repository.PersonalRepository;
import com.proyecto.app.service.PersonalService;

@Service
public  class PersonalServiceImpl extends  GenericService<Personal, Integer> implements PersonalService{

	@Autowired
	private PersonalRepository PersonalRepository;
	
	@Override
	public CrudRepository<Personal, Integer> getDao() {
		
		return PersonalRepository;
	}
	
	
}
