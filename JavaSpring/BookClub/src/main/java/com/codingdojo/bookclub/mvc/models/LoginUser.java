package com.codingdojo.bookclub.mvc.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message="Name is required!")
	@Size(min=2, max=50, message="Name must be 2 or more characters!")
	private String name;
	
	public LoginUser() {}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
