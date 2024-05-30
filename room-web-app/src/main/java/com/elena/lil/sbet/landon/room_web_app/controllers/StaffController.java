package com.elena.lil.sbet.landon.room_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elena.lil.sbet.landon.room_web_app.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	private final StaffService staffService;
	
	public StaffController(StaffService staffService) {this.staffService = staffService;}
	
	@GetMapping
	public String getAllStaff(Model model) {
	model.addAttribute( "staff", staffService.getAllStaff());
	return "staff";
	}
	

}
