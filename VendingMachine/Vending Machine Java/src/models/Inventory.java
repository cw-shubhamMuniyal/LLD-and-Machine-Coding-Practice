package models;

import java.util.HashMap;
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

}
