package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.AppUser;
import com.example.api.repository.registrationRepository;

@Service
public class UserService {
	@Autowired
	private registrationRepository regisRepo;
	public AppUser saveUser(AppUser user) {
		return regisRepo.save(user);
	}
	
	public AppUser fetchUserByUsername(String name) {
		return regisRepo.findByUsername(name);
	}
}
