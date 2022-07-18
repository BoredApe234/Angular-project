package com.example.api.model;

import javax.persistence.*;

import com.example.api.features.features;

@Entity
@Table(name = "usr")
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AppUser() {
		
	}
	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = features.encode(password);
	}
	public AppUser(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = features.encode(password);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
