import State.CashChangeState;
import logic.VendingMachine;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final String cancel = "CANCEL";

    public static void main(String[] args) throws Exception {
        System.out.println("Design Vending Machine!");

        System.out.println("_______________________");
        System.out.println();

        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("Adding inventory in vending machine");
        System.out.println();

        Product product1 = new Product("Burger", 100);
        Product product2 = new Product("Pizza", 20);
        Product product3 = new Product("Icecream", 80);

        Inventory inventory = new Inventory();
        inventory.addItem(1, product1);
        inventory.addItem(2, product2);
        inventory.addItem(3, product3);

        vendingMachine.setInventory(inventory);

        System.out.println("Displaying inventory:");
        vendingMachine.displayInventory();
        System.out.println();

        System.out.println("Press Insert Coin button to start using Vending machine!");
        System.out.println();

        vendingMachine.pressInsertCashButton();

        System.out.println("Now start entering coins!");
        System.out.println();

        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(CoinType.ONE));
        coins.add(new Coin(CoinType.TWENTY));
        coins.add(new Coin(CoinType.TWENTY));
        coins.add(new Coin(CoinType.TWENTY));

        vendingMachine.setPrice(coins);

        System.out.println("You entered total coins of Rs " + vendingMachine.getPriceEntered());
        System.out.println();

        System.out.println("Please press product button to select item from a shelf!");
        System.out.println();

        vendingMachine.pressSelectProductButton();

        System.out.println("Now to select item, enter its code, written beside item, then press Enter!");
        System.out.println();

        Integer code = 2;

        vendingMachine.setCode(code);

        System.out.println("You entered code " + vendingMachine.getcodeEntered());
        System.out.println();

//        Let's say user presses cancel button after entering coins and selecting product
//        if (cancel.equals("CANCEL")) {
//
//            vendingMachine.cancelPayment();
//            return;
//        }

        vendingMachine.validatePrice();

        vendingMachine.returnChange();

        vendingMachine.dispenseProduct();

    }
}