package com.skteam.rentingsystem.controller;

import com.skteam.rentingsystem.dao.UserDAO;
import com.skteam.rentingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	@GetMapping("/menu")
	public String showMainPage() {
		return "main-menu";
	}


}
