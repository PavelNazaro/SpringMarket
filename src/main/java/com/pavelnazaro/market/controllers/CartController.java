package com.pavelnazaro.market.controllers;

import com.pavelnazaro.market.bins.Cart;
import com.pavelnazaro.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ProductsService productsService;
    private Cart cart;

    @Autowired
    public CartController(ProductsService productsService, Cart cart) {
        this.productsService = productsService;
        this.cart = cart;
    }

    @GetMapping
    public String showCart(Model model){
        model.addAttribute("cart", cart);
        model.addAttribute("productsService", productsService);
        return "cart";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam Long id, @RequestParam int count){
        cart.add(productsService.findById(id), count);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id){
        cart.remove(productsService.findById(id));
        return "redirect:/cart";
    }

    @GetMapping("/delete_all")
    public String deleteAllFromCart(){
        cart.removeAll();
        return "redirect:/cart";
    }
}