package com.pavelnazaro.market.controllers;

import com.pavelnazaro.market.beans.Cart;
import com.pavelnazaro.market.entities.Order;
import com.pavelnazaro.market.entities.User;
import com.pavelnazaro.market.services.OrdersService;
import com.pavelnazaro.market.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;

@Controller
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrdersController {
    private UsersService usersService;
    private OrdersService ordersService;
    private Cart cart;

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void confirmOrder(Principal principal, @RequestParam String address) {
        User user = usersService.findByPhone(principal.getName()).get();
        Order order = new Order(user, cart, user.getPhone(), address);
        order = ordersService.saveOrder(order);
    }
}
