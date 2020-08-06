package com.pavelnazaro.market.bins;

import com.pavelnazaro.market.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<ProductsInCart> listProducts;

    public Cart() {
        this.listProducts = new ArrayList<>();
    }

    public List<ProductsInCart> getListProducts() {
        return listProducts;
    }

    public void add(ProductsInCart productsInCart){
        listProducts.add(productsInCart);
    }

    public void remove(Product product){
        listProducts.removeIf(item -> item.getProduct().getId().equals(product.getId()));
    }

    public void removeAll(){
        listProducts.clear();
    }
}
