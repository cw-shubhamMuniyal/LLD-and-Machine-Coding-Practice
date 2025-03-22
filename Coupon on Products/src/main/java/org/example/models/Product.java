package org.example.models;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Product {

    public Product() {

    }

    private String name;
    private Double price;
    private ProductType productType;

    public Product(@NonNull final String name,
                   @NonNull final Double price,
                   @NonNull final ProductType productType) {

        this.name = name;
        this.price = price;
        this.productType = productType;
    }
}
