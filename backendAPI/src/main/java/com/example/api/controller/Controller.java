package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.features.features;
import com.example.api.model.AppUser;
import com.example.api.services.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	@Autowired
	private UserService service;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/signup")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<AppUser> RegisterUser(@RequestBody AppUser user) {
		String temppass = user.getPassword();
		user.setPassword(temppass);
		AppUser usr=null;
		temppass = features.encode(temppass);
		try {
			usr = service.saveUser(user);
			return new ResponseEntity<>(usr,HttpStatus.OK);
		}catch(Exception e){
			log.debug(e.getMessage());
		}
		return new ResponseEntity<>(usr,HttpStatus.NOT_ACCEPTABLE);		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<AppUser> getUser(@RequestBody AppUser user){
		String tempUsername = user.getUsername();
		String temppassword = features.encode(user.getPassword());
		AppUser userObj = null;
		try {
			userObj = service.fetchUserByUsernameandPassword(tempUsername, temppassword);
			if(userObj.getUsername()!=null&&userObj.getPassword()!=null)
				return new ResponseEntity<>(userObj,HttpStatus.OK);
		}
		catch(Exception e) {
			log.debug(e.getMessage());
		}
		return new ResponseEntity<>(userObj,HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/usernames/{name}")
	public List<String> usernameSuggeton(@PathVariable("name") String name) {
		List<String> names = new ArrayList<String>();
		String j=null;
		for(int i=0;i<3;i++) {
			j = features.genUsername(name);
			names.add(j);
		}
		names.add(name);
		return names;
	} 
//	@PostMapping("/login/v1") 
	//public logins()
}
