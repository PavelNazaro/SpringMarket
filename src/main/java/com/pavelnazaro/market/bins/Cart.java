package com.pavelnazaro.market.bins;

import com.pavelnazaro.market.entities.Product;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class Cart {
    private Map<Long, Integer> listProducts;

    public Cart() {
        this.listProducts = new HashMap<>();
    }

    public Map<Long, Integer> getListProducts() {
        return listProducts;
    }

    public void add(Product product, int count){
        System.out.println("Contains: " + listProducts.containsKey(product.getId()));
        if (listProducts.containsKey(product.getId())) {
            System.out.println("!!! " + listProducts.get(product.getId()));
            count += listProducts.get(product.getId());
        }
        listProducts.put(product.getId(), count);
        for (Map.Entry entry : listProducts.entrySet()) {
            System.out.println("Key: " + entry.getKey()+ " Value: "
                    + entry.getValue());
        }
        System.out.println("----------------------");
    }

    public void remove(Product product){
        listProducts.remove(product.getId());
    }

    public void removeAll(){
        listProducts.clear();
    }
}
