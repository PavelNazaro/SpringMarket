package com.pavelnazaro.market.controllers;

import com.pavelnazaro.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private UsersService usersService;

    @Autowired
    public ProfileController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showUser(Principal principal, Model model){
        model.addAttribute("user", usersService.findOneByPhone(principal.getName()));
        return "profile";
    }
}