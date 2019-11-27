package com.proyecto.app.repository;



import org.springframework.data.repository.CrudRepository;

import com.proyecto.app.models.Personal;


public interface PersonalRepository extends CrudRepository<Personal, Integer>{
	
}
