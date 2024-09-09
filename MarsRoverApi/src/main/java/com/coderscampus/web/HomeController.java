package com.coderscampus.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.service.MarsRoverApiService;

@Controller
public class HomeController {
	
	private MarsRoverApiService roverService;
	
	@GetMapping(value="/")
	public String getHomeView(ModelMap model) {

		return "index";
	}
	

}
