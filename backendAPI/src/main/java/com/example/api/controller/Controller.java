package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.features.features;
import com.example.api.model.AppUser;
import com.example.api.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:4200")
	public AppUser RegisterUser(@RequestBody AppUser user) {
		String temppass = user.getPassword();
		temppass = features.encode(temppass);
		user.setPassword(temppass);
		return service.saveUser(user);		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public AppUser getUser(@RequestBody AppUser user) throws Exception {
		String tempUsername = user.getUsername();
		String temppassword = features.encode(user.getPassword());
		AppUser userobj = null;
		if(tempUsername!=null&&temppassword!=null) {
			userobj = service.fetchUserByUsernameandPassword(tempUsername,temppassword);
		}
		if(userobj == null) {
			throw new Exception("Bad Credentials");
		}
		return userobj;
	}
}
