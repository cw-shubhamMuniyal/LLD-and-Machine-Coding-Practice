package org.example.models;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public void addProduct(@NonNull final Product product) {
        productList.add(product);
    }

    public Double getPrice() {

        Double totalPrice = 0.0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }
}
