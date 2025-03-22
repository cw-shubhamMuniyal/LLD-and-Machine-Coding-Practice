package org.example.decorators;

import lombok.AllArgsConstructor;
import org.example.models.Product;

@AllArgsConstructor
public class DefaultCouponDecorator extends CouponDecorator{

    final Product product;
    final Double discount;

    @Override
    public Double getPrice() {

        Double price = product.getPrice();
        return price - (price * discount) / 100.0;
    }
}
