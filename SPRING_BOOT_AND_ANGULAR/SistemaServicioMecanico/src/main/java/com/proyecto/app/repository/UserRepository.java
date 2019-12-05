package com.proyecto.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.proyecto.app.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{


	User findByEmailIgnoreCase(String username);
	

		
}
