package org.example.decorators;

import lombok.NonNull;
import org.example.models.Product;
import org.example.models.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeCouponDecorator extends CouponDecorator{

    final Product product;
    final Double discount;
    final ProductType productType;

    static final List<ProductType> typesToDiscount = new ArrayList<>();

    static{
        typesToDiscount.add(ProductType.FRUITS);
        typesToDiscount.add(ProductType.ELECTRONICS);
    }

    public ProductTypeCouponDecorator(@NonNull final Product product,
                                      @NonNull final Double discount,
                                      @NonNull final ProductType productType
                                      ) {

        this.product = product;
        this.discount = discount;
        this.productType = productType;
    }

    @Override
    public Double getPrice() {

        Double price = product.getPrice();
        if (typesToDiscount.contains(productType)) {
            return price - (price * discount) / 100.0;
        }
        return price;
    }
}
