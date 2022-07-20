package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.AppUser;
@Repository
public interface registrationRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String name);
	AppUser findByUsernameAndPassword(String name, String password);
}
