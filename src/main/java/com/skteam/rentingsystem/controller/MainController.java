package com.skteam.rentingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/menu")
	public String showMainPage() {
		return "main-menu";
	}
	
}
