package com.proyecto.app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.models.User;
import com.proyecto.app.repository.UserRepository;
import com.proyecto.app.security.security.PasswordUtil;
import com.proyecto.app.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userRepository;
	
	
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreateDate(new Date());
		user.setEnabled(true);
		return userRepository.save(user); 
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmailIgnoreCase(email);
	}
	
}
