package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
