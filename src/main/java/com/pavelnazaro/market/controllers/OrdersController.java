package com.pavelnazaro.market.controllers;

import com.pavelnazaro.market.beans.Cart;
import com.pavelnazaro.market.entities.Order;
import com.pavelnazaro.market.entities.User;
import com.pavelnazaro.market.services.OrdersService;
import com.pavelnazaro.market.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
@Deprecated
public class OrdersController {
    private UsersService usersService;
    private OrdersService ordersService;
    private Cart cart;

    @GetMapping("/create")
    public String createOrder(Principal principal, Model model) {
        User user = usersService.findByPhone(principal.getName()).get();
        model.addAttribute("user", user);
        return "order_info";
    }

    @PostMapping("/confirm")
    @ResponseBody
    public String confirmOrder(Principal principal, @RequestParam String address, @RequestParam String phone) {
        User user = usersService.findByPhone(principal.getName()).get();
        Order order = new Order(user, cart, phone, address);
        order = ordersService.saveOrder(order);
        return order.getId() + " " + order.getPrice();
    }
}
