package com.example.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			
		}
		if(session.getAttribute("activities") == null) {
			ArrayList<String> newList = new ArrayList<String>();
			session.setAttribute("activities", newList);
		}
		model.addAttribute((Integer) session.getAttribute("gold"));
		model.addAttribute((ArrayList<String>) session.getAttribute("activities"));
		return "index.jsp";
	}
	
	
	@PostMapping("/find")
	public String find(
			HttpSession session,
			@RequestParam(value="adventure", required=true) String adventure
			) {
		int numToAdd = (int) (Math.random() * 20);
		switch(adventure) {
		case "farm":
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + numToAdd);
			
			break;
		case "cave":
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + numToAdd);
			break;
		case "house":
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + numToAdd);
			break;
		case "quest":
			numToAdd = (int) (Math.random() * 51);
			if(Math.random() < .5) {
				numToAdd *= -1;
			}
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + numToAdd);
			break;
		default:
			return "redirect:/";
		}
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd");
		ArrayList<String> newList = (ArrayList<String>) session.getAttribute("activities");
		String gainedOrLost = (numToAdd >= 0 ? "gained" : "lost");
		newList.add("You went to the " + adventure + " and " + gainedOrLost + " " + Math.abs(numToAdd) + " gold!" + df.format(date));
		session.setAttribute("activities", newList);
		
		
		return "redirect:/";
	}
}
