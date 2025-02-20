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

    }

    @Override
    public void setPrice(List<Coin> coins) {

    }

    @Override
    public void pressSelectProductButton() {

    }

    @Override
    public void setCode(Integer code) {

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

        Integer cashChange = vendingMachine.getPriceEntered() - product.getPrice();

        if (cashChange > 0) {

            coinDeduction(cashChange);
            System.out.println("Please collect change of " + cashChange + " from cash change coins tray!");
            this.vendingMachine.updateState(new ItemDispenseState(vendingMachine));
        }

    }

//    TO DO: Add logic for setting remaining coins in vending machine after exchange
    private void coinDeduction(Integer cashChange) {

    }
}
