package com.example.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/handleform", method=RequestMethod.POST)
	public String handleForm(
			HttpSession session,
			@RequestParam(value="number", required=true) Integer number,
			@RequestParam(value="city", required=true) String city,
			@RequestParam(value="person", required=true) String person,
			@RequestParam(value="hobby", required=true) String hobby,
			@RequestParam(value="thing", required=true) String thing,
			@RequestParam(value="message", required=true) String message
			) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		
		
		return "redirect:/display";
	}
	
	@RequestMapping(value="/display")
	public String display(HttpSession session, Model model) {
		
		model.addAttribute((Integer) session.getAttribute("number"));
		model.addAttribute((String) session.getAttribute("city"));
		model.addAttribute((String) session.getAttribute("person"));
		model.addAttribute((String) session.getAttribute("hobby"));
		model.addAttribute((String) session.getAttribute("thing"));
		model.addAttribute((String) session.getAttribute("message"));
		
		return "display.jsp";
	}
	
}
