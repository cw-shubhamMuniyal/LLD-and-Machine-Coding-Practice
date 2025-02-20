import logic.VendingMachine;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Design Vending Machine!");

        System.out.println("_______________________");

        VendingMachine vendingMachine = new VendingMachine();

        Product product1 = new Product("Burger", 100);
        Product product2 = new Product("Pizza", 20);
        Product product3 = new Product("Icecream", 80);

        Inventory inventory = new Inventory();
        inventory.addItem(1, product1);
        inventory.addItem(2, product2);
        inventory.addItem(3, product3);

        vendingMachine.setInventory(inventory);

        System.out.println("Press Insert Coin button to start using Vending machine!");

        vendingMachine.pressInsertCashButton();

        System.out.println("Now start entering coins!");

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(CoinType.TWENTY));
        coins.add(new Coin(CoinType.TWENTY));
        coins.add(new Coin(CoinType.TWENTY));
        coins.add(new Coin(CoinType.TWENTY));

        vendingMachine.setPrice(coins);

        System.out.println("Please Select product button to select item from a shelf!");

        vendingMachine.pressSelectProductButton();

        System.out.println("Now to select item, enter its code, written beside item, then press Enter!");

        Integer code = 2;

        vendingMachine.setCode(code);

        vendingMachine.validatePrice();

        vendingMachine.returnChange();

        vendingMachine.dispenseProduct();

    }
}