package models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {

    private final Map<Integer, Product> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(Integer code, Product product) {

        items.put(code, product);
    }

    public Map<Integer, Product> getItems() {
        return items;
    }

    public void displayInventory() {

        for (Map.Entry<Integer, Product> entry : items.entrySet()) {

            Integer code = entry.getKey();
            Product product = entry.getValue();

            System.out.println(
                    "Item code: " + code +
                            "\t,Item name: " + product.getName() +
                            "\t,Item price: " + product.getPrice()

            );
        }

    }

}
