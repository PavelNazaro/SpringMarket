package com.pavelnazaro.market.controllers;

import com.pavelnazaro.market.entities.User;
import com.pavelnazaro.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;
    private User user;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showUser(Principal principal, Model model){
        model.addAttribute("user", usersService.findOneByPhone(principal.getName()));
        model.addAttribute("usersService", usersService);
        return "users";
    }

    @GetMapping("/block/{id}")
    public String blockUser(@PathVariable Long id){
//        user.setIsLocked(true);
        return "redirect:/users";
    }
}