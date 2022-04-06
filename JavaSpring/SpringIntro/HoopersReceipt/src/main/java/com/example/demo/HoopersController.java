package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HoopersController {
	@RequestMapping("/")
	public String index(Model model) {
		String name = "Grace Hoopie";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Chicken strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Rounded Angle Store";
		
		model.addAttribute("name", name);
		model.addAttribute("itemName", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		return "index.jsp";
	}
	
}
