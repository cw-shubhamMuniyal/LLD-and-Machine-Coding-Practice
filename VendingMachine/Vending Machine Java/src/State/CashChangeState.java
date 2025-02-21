package State;

import logic.VendingMachine;
import models.Coin;
import models.Product;

import java.util.List;
import java.util.Map;

public class CashChangeState implements State {

    VendingMachine vendingMachine;

    public CashChangeState(VendingMachine vendingMachine) {

        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCashButton() {

        System.out.println("You cannot click insert coin button in cash change state!");
    }

    @Override
    public void setPrice(List<Coin> coins) {

        System.out.println("You cannot enter price in cash change state!");
    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("You cannot click insert product button in cash change state!");
    }

    @Override
    public void setCode(Integer code) {

        System.out.println("You cannot enter code in cash change state!");
    }

    @Override
    public void validatePrice() {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

        Map<Integer, Product> items = vendingMachine.getInventory().getItems();

        Product product = items.get(vendingMachine.getcodeEntered());

        int cashChange = vendingMachine.getPriceEntered() - product.getPrice();

        if (cashChange > 0) {

            coinDeduction(cashChange);
            System.out.println("Please collect change of " + cashChange + " from cash change coins tray!");
            System.out.println();
        }
        this.vendingMachine.updateState(new ItemDispenseState(vendingMachine));

    }

//    TO DO: Add logic for setting remaining coins in vending machine after exchange
    private void coinDeduction(Integer cashChange) {

    }
}
