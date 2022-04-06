package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Notice that we didn't use a rest controller. THat is for when we want to return JSON. Use ONLY controller if you want to return a template.
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
}
