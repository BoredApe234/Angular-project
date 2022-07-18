package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.model.AppUser;
import com.example.api.repository.registrationRepository;

@SpringBootApplication
public class BackendApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}
	@Autowired
	registrationRepository repo;
	@Override
	public void run(String... args) throws Exception{
		repo.save(new AppUser("Harsh","1111"));
		repo.save(new AppUser("Abhinav","1111"));
		repo.save(new AppUser("Itee","1111"));
		repo.save(new AppUser("Yaksha","1111"));
	}

}
