package com.skteam.rentingsystem.controller;

import com.skteam.rentingsystem.entity.User;
import com.skteam.rentingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get")
    public String getUser(Model model) {

        User tempUser = userService.getUser("ajayy");

        System.out.println(tempUser);

        return "get-user";

    }

}
