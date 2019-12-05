package com.proyecto.app.controllersRest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.app.models.User;
import com.proyecto.app.security.security.Response;
import com.proyecto.app.service.UserService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class PreLoginRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser = userService.save(user);
		if(dbUser != null) {
			return new ResponseEntity<Response>(new Response("User is Saved Successfully"), HttpStatus.OK);
		}
		return null;
	}
}
