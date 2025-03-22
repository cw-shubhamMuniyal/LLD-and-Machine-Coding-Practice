package org.example;

import org.example.decorators.DefaultCouponDecorator;
import org.example.decorators.ProductTypeCouponDecorator;
import org.example.models.Product;
import org.example.models.ProductType;
import org.example.models.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        System.out.println("Practicing Coupon on products lld and machine coding!");

        Product product1 =
                new ProductTypeCouponDecorator(
                        new DefaultCouponDecorator(
                                new Product(
                                    "apple",
                                    100.0,
                                    ProductType.FRUITS
                                ),
                                10.0
                        ),
                        10.0,
                        ProductType.FRUITS
                );

        Product product2 =
                new ProductTypeCouponDecorator(
                        new DefaultCouponDecorator(
                                new Product(
                                        "Prisoner of Azkaban",
                                        100.0,
                                        ProductType.BOOKS
                                ),
                                10.0
                        ),
                        10.0,
                        ProductType.BOOKS
                );

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        Double price = shoppingCart.getPrice();
        System.out.println(price);
    }
}