package com.proyecto.app.service;

import java.util.List;

import com.proyecto.app.models.User;

public interface UserService  {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
