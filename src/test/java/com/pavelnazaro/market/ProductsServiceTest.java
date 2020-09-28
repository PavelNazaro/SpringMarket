package com.pavelnazaro.market;

import com.pavelnazaro.market.entities.dtos.ProductDto;
import com.pavelnazaro.market.services.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductsServiceTest {
    @Spy
    private List<ProductDto> productDtos;

    @Autowired
    private ProductsService productsService;

    @Test
    public void productsControllerGetAllProductsTest(){
        productDtos = productsService.findAllDtos();

        Assertions.assertEquals(4, productDtos.size());
    }
}
