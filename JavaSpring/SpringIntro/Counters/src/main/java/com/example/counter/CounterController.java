package com.example.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/display")
	public String display(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		model.addAttribute("count", (Integer) session.getAttribute("count"));
		
		return "display.jsp";
	}
	
	@RequestMapping("/doubleIndex")
	public String doubleIndex(HttpSession session) {
		session.setAttribute("count", (Integer) session.getAttribute("count") + 2);
	
		return "redirect:/display";
	}
	
	@RequestMapping("/resetCount")
	public String resetCount(HttpSession session) {
		session.setAttribute("count", 0);
		
		return "redirect:/display";
	}
	
	
	
}
