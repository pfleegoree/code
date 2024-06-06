package com.elena.lil.sbet.landon.room_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationController {
	@GetMapping("/login")
	public String getlogin() {
		return "Login";
		
	}

}
