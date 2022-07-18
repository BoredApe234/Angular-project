package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.features.features;
import com.example.api.model.AppUser;
import com.example.api.services.UserService;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public AppUser RegisterUser(@RequestBody AppUser user) {
		String temppass = user.getPassword();
		temppass = features.encode(temppass);
		user.setPassword(temppass);
		return service.saveUser(user);		
	}
	@GetMapping("/login/{username}/{password}")
	public AppUser getUser(@PathVariable("username") String username, @PathVariable("password") String pass) {
		AppUser user = service.fetchUserByUsername(username);
	//	boolean auth = false;
//		if(user.getPassword() == features.encode(pass)) {
//			auth = true;
//		}
		return (features.decode(user.getPassword()).contentEquals(pass))?user:null;
	}
}
