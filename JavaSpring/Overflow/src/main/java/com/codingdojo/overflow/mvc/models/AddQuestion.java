package com.codingdojo.overflow.mvc.models;

import javax.validation.constraints.NotBlank;

public class AddQuestion {

	@NotBlank(message="That's not much of a question...")
	private String question;
	
	@NotBlank(message="You need at least one tag!")
	private String tags;
	
	public AddQuestion() {}
	
	public AddQuestion(String question, String tags) {
		 this.question = question;
		 this.tags = tags;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
	
}
