package com.pavelnazaro.market;

import com.pavelnazaro.market.beans.Cart;
import com.pavelnazaro.market.entities.Product;
import com.pavelnazaro.market.services.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartTest {
    @Autowired
    private Cart cart;

    @Autowired
    private ProductsService productsService;

    @Test
    public void cartAddTest(){
        Product product = productsService.findAll().get(0);
        cart.add(product);
        Assertions.assertEquals(1, cart.getItems().size());
        cart.clear();
        Assertions.assertEquals(0, cart.getItems().size());
    }
}
