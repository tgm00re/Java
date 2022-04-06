package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	Date currentDate  = new Date();
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", dateFormat.format(currentDate));
		return "Date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("time",	timeFormat.format(currentDate));
		return "Time.jsp";
	}
	
	
}
