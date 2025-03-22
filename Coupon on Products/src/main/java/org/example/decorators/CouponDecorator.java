package org.example.decorators;

import lombok.NonNull;
import org.example.models.Product;
import org.example.models.ProductType;

public abstract class CouponDecorator extends Product {

    public CouponDecorator() {
        super();
    }

    abstract public Double getPrice();
}
