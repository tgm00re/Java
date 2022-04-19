package com.codingdojo.projectmanager.mvc.models;

import javax.validation.constraints.NotBlank;

public class LoginUser {

	@NotBlank(message="Remember to enter an email!")
	private String email;
	
	@NotBlank(message="Remember to type in your password!")
	private String password;
	
	public LoginUser() {}
	
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
