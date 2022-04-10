package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hello") //THIS PREPENDS /hello to ALL routes within the class!
public class HomeController {

	@RequestMapping(value="/world", method=RequestMethod.GET) //This is the same @RequestMapping("/world")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/custom_message")
	public String customMessage() {
		return "Choo Choo";
	}
	
}
