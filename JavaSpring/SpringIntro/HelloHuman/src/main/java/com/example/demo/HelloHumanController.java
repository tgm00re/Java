package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	
	@RequestMapping("/")
	public String index(@RequestParam(value="first_name", required=false) String first_name, @RequestParam(value="last_name", required=false) String last_name, @RequestParam(value="times", required=false, defaultValue = "1") Integer timesParam ) {
		
		String firstName = first_name;
		String lastName = last_name;
		int times = timesParam;
		
		if(firstName == null) {
			firstName = "human";
		}
		if(lastName == null) {
			lastName = "";
		}
		if(times < 1) {
			times = 1;
		}
		
		String initialMessage = firstName + " " + lastName;
		String message = "Hello ";
		for(int i = 1; i <= times; i++) {
			message += " " + initialMessage;
			
		}
		
		return message;
		
	}
	
}
