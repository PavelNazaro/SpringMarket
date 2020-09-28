package com.pavelnazaro.market;

import com.pavelnazaro.market.controllers.ProductsController;
import com.pavelnazaro.market.entities.dtos.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductsControllerTest {
    @Spy
    private List<ProductDto> productDtos;

    @Autowired
    private ProductsController productsController;

    @Test
    public void productsControllerGetAllProductsTest(){
        productDtos = productsController.getAllProducts();

        Assertions.assertEquals(4, productDtos.size());
    }
}
